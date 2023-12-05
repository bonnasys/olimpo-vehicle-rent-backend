package br.com.bonnasys.olimpo.users.app.rest.dto.response;

import br.com.bonnasys.olimpo.cities.app.rest.dto.CityResponse;
import br.com.bonnasys.olimpo.users.domain.enums.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class UserDetailedResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private UserTypeEnum type;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String registration;
    private CityResponse city;
    private RoleResponse role;

    public record RoleResponse(String id, String name) {
    }
}
