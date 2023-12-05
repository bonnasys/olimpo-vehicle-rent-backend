package br.com.bonnasys.olimpo.users.domain.usecases.retrieve.get;

import br.com.bonnasys.olimpo.users.domain.model.User;

public interface FindUserByIdUseCase {

    User invoke(String id);
}
