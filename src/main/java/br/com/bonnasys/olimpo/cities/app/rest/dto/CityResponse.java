package br.com.bonnasys.olimpo.cities.app.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CityResponse(@Schema(example = "a081e6a0-96bd-402f-be88-1b52c0586adf")
                           String id,
                           @Schema(example = "Sumaré")
                           String name,
                           @Schema(example = "SP")
                           String state) {
}
