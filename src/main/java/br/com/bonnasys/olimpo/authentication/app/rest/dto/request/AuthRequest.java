package br.com.bonnasys.olimpo.authentication.app.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record AuthRequest(
        @Schema(example = "gabriel.rodrigues@bonnasys.com.br")
        @NotBlank
        String username,
        @Schema(example = "PtL$29naS")
        @NotBlank
        String password) {
}
