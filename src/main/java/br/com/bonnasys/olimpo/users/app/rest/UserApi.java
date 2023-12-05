package br.com.bonnasys.olimpo.users.app.rest;

import br.com.bonnasys.olimpo.common.openapi.model.request.PageParamRequest;
import br.com.bonnasys.olimpo.common.openapi.model.response.PageResponseOpenApi.UserResponseOpenApi;
import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserClientRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserEmployeeRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.request.CreateUserRequest;
import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserDetailedResponse;
import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserSummaryResponse;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Tag(name = "users")
@RequestMapping("users")
public interface UserApi {

    @GetMapping
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserResponseOpenApi.class)))
    ResponseEntity<Page<UserSummaryResponse>> search(@Schema(implementation = PageParamRequest.class)
                                                     @PageableDefault
                                                     Pageable pageable);

    @PostMapping
    @ApiResponse(responseCode = "201", headers = @Header(name = "Location"), description = "create request was successful")
    ResponseEntity<Void> create(@Schema(oneOf = {CreateUserEmployeeRequest.class, CreateUserClientRequest.class})
                                @RequestBody @Valid CreateUserRequest request);

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable String id);

    @GetMapping("{id}")
    ResponseEntity<UserDetailedResponse> findById(@PathVariable String id);

    @PatchMapping("{id}")
    ResponseEntity<UserDetailedResponse> update(@PathVariable String id, @RequestBody Map<String, Object> fields);

}
