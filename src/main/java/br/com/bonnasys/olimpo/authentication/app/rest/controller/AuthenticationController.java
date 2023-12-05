package br.com.bonnasys.olimpo.authentication.app.rest.controller;

import br.com.bonnasys.olimpo.authentication.app.rest.AuthenticationApi;
import br.com.bonnasys.olimpo.authentication.app.rest.dto.request.AuthRequest;
import br.com.bonnasys.olimpo.authentication.app.rest.dto.response.JwtResponse;
import br.com.bonnasys.olimpo.authentication.domain.model.Token;
import br.com.bonnasys.olimpo.authentication.domain.usecases.authenticate.AuthenticationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController implements AuthenticationApi {
    private final AuthenticationUseCase authenticationUseCase;

    @Override
    public ResponseEntity<JwtResponse> authenticate(AuthRequest request) {
        Token token = authenticationUseCase.invoke(request.username(), request.password());
        return ResponseEntity.ok(new JwtResponse(token.jwt(), token.expiresIn()));
    }
}
