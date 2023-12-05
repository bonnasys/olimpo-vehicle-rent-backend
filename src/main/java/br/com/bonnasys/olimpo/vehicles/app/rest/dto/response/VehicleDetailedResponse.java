package br.com.bonnasys.olimpo.vehicles.app.rest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

public record VehicleDetailedResponse(@Schema(example = "5795cfe7-250e-4e78-8c4a-80fae67f5a76")
                                      String id,
                                      @Schema(example = "Fusion LT FLEX 2.0")
                                      String model,
                                      @Schema(example = "O melhor a ser apresentado pela automotiva")
                                      String description,
                                      Set<CharacteristicResponse> characteristics,
                                      CategoryResponse category,
                                      CityResponse city,
                                      @Schema(example = "https://pixabay.com/pt/illustrations/carro-veículo-carro-esporte-49278")
                                      String vehicleImage) {
    public record CharacteristicResponse(@Schema(example = "986657ef-77cf-47fc-90eb-48f6901ca7dc")
                                         String id,
                                         @Schema(example = "Quatro portas") String name,
                                         @Schema(example = "QUATRO_PORTAS") String icon) {
    }

    public record CategoryResponse(@Schema(example = "dd253573-28e2-4b3b-b084-140200a992ae")
                                   String id,
                                   @Schema(example = "SUV") String name,
                                   @Schema(example = "5 stars") String qualification,
                                   @Schema(example = "SUVs são grandes") String description) {
    }

    public record CityResponse(@Schema(example = "4c0229ac-fa66-467e-b849-9919395aa00c")
                               String id,
                               @Schema(example = "Sumaré") String name,
                               @Schema(example = "SP") String state) {
    }
}
