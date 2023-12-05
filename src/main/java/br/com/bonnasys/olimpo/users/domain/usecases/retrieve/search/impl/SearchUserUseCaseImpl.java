package br.com.bonnasys.olimpo.users.domain.usecases.retrieve.search.impl;

import br.com.bonnasys.olimpo.users.domain.model.User;
import br.com.bonnasys.olimpo.users.domain.repository.UserRepository;
import br.com.bonnasys.olimpo.users.domain.usecases.retrieve.search.SearchUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchUserUseCaseImpl implements SearchUserUseCase {
    private final UserRepository userRepository;

    @Override
    public Page<User> invoke(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
