package br.com.bonnasys.olimpo.vehicles.domain.usecases;

import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;
import br.com.bonnasys.olimpo.vehicles.domain.usecases.create.CreateVehicleUseCase;
import br.com.bonnasys.olimpo.vehicles.domain.usecases.create.command.CreateVehicleCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VehicleFacade {
    private final CreateVehicleUseCase createVehicleUseCase;

    public Vehicle createVehicleUseCase(CreateVehicleCommand command) {
        return createVehicleUseCase.invoke(command);
    }
}
