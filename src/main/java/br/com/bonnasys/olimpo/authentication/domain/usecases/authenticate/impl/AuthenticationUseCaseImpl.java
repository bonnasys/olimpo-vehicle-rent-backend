package br.com.bonnasys.olimpo.authentication.domain.usecases.authenticate.impl;

import br.com.bonnasys.olimpo.authentication.domain.model.Token;
import br.com.bonnasys.olimpo.authentication.domain.usecases.authenticate.AuthenticationUseCase;
import br.com.bonnasys.olimpo.common.service.JwtService;
import br.com.bonnasys.olimpo.users.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public Token invoke(String username, String password) {
        var autenticacao = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(autenticacao);
        var usuario = userRepository
                .findUserByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("Email ou senha invalido."));
        String token = jwtService.generateToken(usuario);
        return new Token(token, 10000 * 60 + 60 * 40);
    }
}
