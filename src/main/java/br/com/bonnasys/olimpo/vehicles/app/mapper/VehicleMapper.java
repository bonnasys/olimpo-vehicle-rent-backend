package br.com.bonnasys.olimpo.vehicles.app.mapper;

import br.com.bonnasys.olimpo.vehicles.app.rest.dto.request.CreateVehicleRequest;
import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {


    @Mapping(target = "reserves", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "characteristics", ignore = true)
    @Mapping(target = "category", ignore = true)
    Vehicle toVehicle(CreateVehicleRequest vehicle);
}
