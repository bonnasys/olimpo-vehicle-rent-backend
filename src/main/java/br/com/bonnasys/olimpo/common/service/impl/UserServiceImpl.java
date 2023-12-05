package br.com.bonnasys.olimpo.common.service.impl;

import br.com.bonnasys.olimpo.common.service.UserService;
import br.com.bonnasys.olimpo.users.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService getUserDetails() {
        return (email) -> userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("usuario não encontrado"));
    }
}
