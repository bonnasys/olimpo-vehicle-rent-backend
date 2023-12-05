package br.com.bonnasys.olimpo.users.app.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserEmployeeRequest extends CreateUserRequest {

    @NotBlank
    @Schema(example = "BNA-123")
    private String registration;

    @NotBlank
    private String role;
}
