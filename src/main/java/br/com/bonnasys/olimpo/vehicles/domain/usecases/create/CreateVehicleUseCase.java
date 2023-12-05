package br.com.bonnasys.olimpo.vehicles.domain.usecases.create;

import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;
import br.com.bonnasys.olimpo.vehicles.domain.usecases.create.command.CreateVehicleCommand;

public interface CreateVehicleUseCase {
    Vehicle invoke(CreateVehicleCommand command);
}
