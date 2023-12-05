package br.com.bonnasys.olimpo.users.domain.usecases.delete.impl;

import br.com.bonnasys.olimpo.users.domain.exception.UserNotFoundException;
import br.com.bonnasys.olimpo.users.domain.repository.UserRepository;
import br.com.bonnasys.olimpo.users.domain.usecases.delete.DeleteUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {
    private final UserRepository userRepository;

    @Override
    public void invoke(String id) {
        userRepository.findById(id).ifPresentOrElse(
                userRepository::delete,
                () -> {
                    throw new UserNotFoundException();
                }
        );
    }
}
