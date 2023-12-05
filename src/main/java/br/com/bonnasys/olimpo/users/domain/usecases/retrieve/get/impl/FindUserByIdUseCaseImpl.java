package br.com.bonnasys.olimpo.users.domain.usecases.retrieve.get.impl;

import br.com.bonnasys.olimpo.users.domain.exception.UserNotFoundException;
import br.com.bonnasys.olimpo.users.domain.model.User;
import br.com.bonnasys.olimpo.users.domain.repository.UserRepository;
import br.com.bonnasys.olimpo.users.domain.usecases.retrieve.get.FindUserByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {
    private final UserRepository userRepository;

    @Override
    public User invoke(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
