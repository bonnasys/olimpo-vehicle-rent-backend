package br.com.bonnasys.olimpo.users.app.rest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSummaryResponse {
    @Schema(example = "d6b6cef2-d499-4d0a-930d-9e3b4f7cb1e9")
    private String id;
    @Schema(example = "Gabriel Rodrigues")
    private String name;
    @Schema(example = "gabriel.rodrigues@bonnasys.com.br")
    private String email;
}
