package br.com.bonnasys.olimpo.users.domain.usecases;

import br.com.bonnasys.olimpo.users.domain.model.User;
import br.com.bonnasys.olimpo.users.domain.usecases.create.CreateUserUseCase;
import br.com.bonnasys.olimpo.users.domain.usecases.delete.DeleteUserUseCase;
import br.com.bonnasys.olimpo.users.domain.usecases.retrieve.get.FindUserByIdUseCase;
import br.com.bonnasys.olimpo.users.domain.usecases.retrieve.search.SearchUserUseCase;
import br.com.bonnasys.olimpo.users.domain.usecases.update.UpdateUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class UserFacade {
    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final SearchUserUseCase searchUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public User createUserUseCase(User user) {
        return createUserUseCase.invoke(user);
    }

    public User findUserByIdUseCase(String id) {
        return findUserByIdUseCase.invoke(id);
    }

    public Page<User> searchUserUseCase(Pageable pageable) {
        return searchUserUseCase.invoke(pageable);
    }

    public void deleteUserUseCase(String id) {
        deleteUserUseCase.invoke(id);
    }

    public User updateUserUseCase(String id, Map<String, Object> fields) {
        return updateUserUseCase.invoke(id, fields);
    }

}
