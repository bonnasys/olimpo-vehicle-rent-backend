package br.com.bonnasys.olimpo.cities.app.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CreateCityRequest(
        @Schema(example = "Niteroi")
        @NotBlank
        String name,
        @Schema(example = "SP")
        @NotBlank
        String state) {
}
