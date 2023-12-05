package br.com.bonnasys.olimpo.users.domain.usecases.create.impl;

import br.com.bonnasys.olimpo.cities.domain.exception.CityNotFoundException;
import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.cities.domain.repository.CityRepository;
import br.com.bonnasys.olimpo.users.domain.exception.UserEmailAlreadyInUseException;
import br.com.bonnasys.olimpo.users.domain.model.Client;
import br.com.bonnasys.olimpo.users.domain.model.Employee;
import br.com.bonnasys.olimpo.users.domain.model.Role;
import br.com.bonnasys.olimpo.users.domain.model.User;
import br.com.bonnasys.olimpo.users.domain.repository.RoleRepository;
import br.com.bonnasys.olimpo.users.domain.repository.UserRepository;
import br.com.bonnasys.olimpo.users.domain.usecases.create.CreateUserUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CityRepository cityRepository;
    private final PasswordEncoder encoder;

    @Override
    public User invoke(User request) {
        userRepository.findUserByEmail(request.getEmail())
                .ifPresent(it -> {
                    log.error("[CreateUserUseCaseImpl]: user already exists");
                    throw new UserEmailAlreadyInUseException(request.getEmail());
                });

        if (request instanceof Client client) {
            String cityId = client.getCity().getId();
            City city = cityRepository.findById(cityId).orElseThrow(CityNotFoundException::new);
            client.setCity(city);
        }

        if (request instanceof Employee employee) {
            String name = employee.getRole().getName();
            Role role = roleRepository.findRoleByName(name).orElseGet(() -> {
                Role newRole = new Role(name);
                return roleRepository.save(newRole);
            });
            employee.setRole(role);
        }

        String encodedPassword = encoder.encode(request.getPassword());
        request.setPassword(encodedPassword);
        return userRepository.save(request);
    }
}
