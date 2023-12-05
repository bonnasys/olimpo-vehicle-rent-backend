package br.com.bonnasys.olimpo.vehicles.app.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record CreateVehicleRequest(@Schema(example = "Fusion LT FLEX 2.0")
                                   @NotBlank String model,
                                   @Schema(example = "O melhor a ser apresentado pela automotiva")
                                   @NotBlank
                                   @Size(min = 10, max = 255)
                                   String description,
                                   @Schema(example = "[ \"2b2a8627-85b9-417c-b593-c0b757802d84\"]")
                                   @NotEmpty Set<String> characteristicIds,
                                   @Schema(example = "c0c2327c-22bd-4d59-972d-d3acd6f6ba79")
                                   @NotBlank String categoryId,
                                   @Schema(example = "b93cc690-3cef-4f6a-8646-1b962f79334c")
                                   @NotBlank String cityId) {
}
