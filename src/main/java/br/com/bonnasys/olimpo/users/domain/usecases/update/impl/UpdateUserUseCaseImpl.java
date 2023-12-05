package br.com.bonnasys.olimpo.users.domain.usecases.update.impl;

import br.com.bonnasys.olimpo.users.domain.model.User;
import br.com.bonnasys.olimpo.users.domain.repository.UserRepository;
import br.com.bonnasys.olimpo.users.domain.usecases.update.UpdateUserUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final UserRepository userRepository;
    private final ObjectMapper mapper;

    @Override
    public User invoke(String id, Map<String, Object> fields) {
        User user = userRepository.findById(id).orElseThrow();
        User input = mapper.convertValue(fields, User.class);
        fields.forEach((property, value) -> {
            Field field = ReflectionUtils.findField(User.class, property);
            if (field == null) {
                log.error("Field not found! '%s', I will skip it.".formatted(property));
                return;
            }
            field.setAccessible(true);
            Object newValue = ReflectionUtils.getField(field, input);
            ReflectionUtils.setField(field, user, newValue);
        });
        return userRepository.save(user);
    }
}
