package br.com.bonnasys.olimpo.users.app.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserClientRequest extends CreateUserRequest {

    @NotBlank
    private String cityId;

}
