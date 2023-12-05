package br.com.bonnasys.olimpo.vehicles.domain.usecases.create.command;

import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;

import java.util.Set;

public record CreateVehicleCommand(Vehicle vehicle, Set<String> characteristicIds, String categoryId, String cityId) {
}
