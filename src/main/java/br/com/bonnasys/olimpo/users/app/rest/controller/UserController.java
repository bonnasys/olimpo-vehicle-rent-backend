package br.com.bonnasys.olimpo.users.app.rest.controller;

import br.com.bonnasys.olimpo.users.app.mapper.UserMapper;
import br.com.bonnasys.olimpo.users.app.rest.UserApi;
import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserDetailedResponse;
import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserSummaryResponse;
import br.com.bonnasys.olimpo.users.domain.model.User;
import br.com.bonnasys.olimpo.users.domain.usecases.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {
    private final UserFacade userFacade;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<Page<UserSummaryResponse>> search(Pageable pageable) {
        Page<User> users = userFacade.searchUserUseCase(pageable);
        Page<UserSummaryResponse> map = users.map(userMapper::toUserSummaryResponse);
        return ResponseEntity.ok(map);
    }

    @Override
    public ResponseEntity<Void> create(CreateUserRequest request) {
        User userRequest = userMapper.toUser(request);
        User userCreated = userFacade.createUserUseCase(userRequest);
        return ResponseEntity.created(
                        fromCurrentRequest().path("/{id}").buildAndExpand(userCreated).toUri())
                .build();
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        userFacade.deleteUserUseCase(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDetailedResponse> findById(String id) {
        var user = userFacade.findUserByIdUseCase(id);
        UserDetailedResponse response = userMapper.toUserDetailedResponse(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserDetailedResponse> update(String id, Map<String, Object> fields) {
        return null;
    }
}
