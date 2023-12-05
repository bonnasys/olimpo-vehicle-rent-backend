package br.com.bonnasys.olimpo.vehicles.app.rest.controller;

import br.com.bonnasys.olimpo.vehicles.app.mapper.VehicleMapper;
import br.com.bonnasys.olimpo.vehicles.app.rest.VehicleApi;
import br.com.bonnasys.olimpo.vehicles.app.rest.dto.request.CreateVehicleRequest;
import br.com.bonnasys.olimpo.vehicles.app.rest.dto.response.VehicleDetailedResponse;
import br.com.bonnasys.olimpo.vehicles.app.rest.dto.response.VehicleSummaryResponse;
import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;
import br.com.bonnasys.olimpo.vehicles.domain.usecases.VehicleFacade;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class VehicleController implements VehicleApi {
    private final VehicleFacade vehicleFacade;
    private final VehicleMapper mapper;

    @Override
    public ResponseEntity<Void> create(CreateVehicleRequest request) {
        Vehicle vehicle = mapper.toVehicle(request);
        return null;
    }

    @Override
    public ResponseEntity<VehicleDetailedResponse> findById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<VehicleSummaryResponse>> search(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return null;
    }

    @Override
    public ResponseEntity<VehicleDetailedResponse> update(String id, Map<String, Object> fields) {
        return null;
    }
}
