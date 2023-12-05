package br.com.bonnasys.olimpo.users.app.rest.dto.request;

import br.com.bonnasys.olimpo.users.app.rest.validation.Password;
import br.com.bonnasys.olimpo.users.app.rest.validation.Phone;
import br.com.bonnasys.olimpo.users.domain.enums.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateUserEmployeeRequest.class, name = "EMPLOYEE"),
        @JsonSubTypes.Type(value = CreateUserClientRequest.class, name = "CLIENT")
})
public class CreateUserRequest {

    @NotBlank
    @Schema(example = "Gabriel Rodrigues")
    private String name;

    @Phone
    @NotBlank
    @Schema(example = "(19) 99999-9999")
    private String phone;

    @Email
    @NotBlank
    @Schema(example = "gabriel.rodrigues@bonnasys.com.br")
    private String email;

    @Password
    @NotBlank
    @Schema(example = "PtL$29naS")
    private String password;

    private UserTypeEnum type;
}
