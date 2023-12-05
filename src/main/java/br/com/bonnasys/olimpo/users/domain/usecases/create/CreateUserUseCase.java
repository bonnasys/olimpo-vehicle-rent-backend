package br.com.bonnasys.olimpo.users.domain.usecases.create;

import br.com.bonnasys.olimpo.users.domain.model.User;

public interface CreateUserUseCase {
    User invoke(User request);
}
