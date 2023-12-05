package br.com.bonnasys.olimpo.authentication.domain.usecases.authenticate;

import br.com.bonnasys.olimpo.authentication.domain.model.Token;

public interface AuthenticationUseCase {

    Token invoke(String username, String password);
}
