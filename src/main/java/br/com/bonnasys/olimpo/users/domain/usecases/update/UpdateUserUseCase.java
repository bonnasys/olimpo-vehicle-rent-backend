package br.com.bonnasys.olimpo.users.domain.usecases.update;

import br.com.bonnasys.olimpo.users.domain.model.User;

import java.util.Map;

public interface UpdateUserUseCase {

    User invoke(String id, Map<String, Object> fields);

}
