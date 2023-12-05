package br.com.bonnasys.olimpo.users.domain.usecases.retrieve.search;

import br.com.bonnasys.olimpo.users.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchUserUseCase {

    Page<User> invoke(Pageable pageable);
}
