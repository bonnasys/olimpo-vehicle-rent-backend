package br.com.bonnasys.olimpo.vehicles.app.rest;

import br.com.bonnasys.olimpo.common.openapi.model.request.PageParamRequest;
import br.com.bonnasys.olimpo.vehicles.app.rest.dto.request.CreateVehicleRequest;
import br.com.bonnasys.olimpo.vehicles.app.rest.dto.response.VehicleDetailedResponse;
import br.com.bonnasys.olimpo.vehicles.app.rest.dto.response.VehicleSummaryResponse;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Tag(name = "vehicles")
@RequestMapping("vehicles")
public interface VehicleApi {

    @PostMapping
    @ApiResponse(responseCode = "201", headers = @Header(name = "Location"))
    @ApiResponse(responseCode = "400")
    @ApiResponse(responseCode = "404")
    ResponseEntity<Void> create(@RequestBody @Valid CreateVehicleRequest vehicle);

    @GetMapping("{id}")
    ResponseEntity<VehicleDetailedResponse> findById(@PathVariable String id);

    @GetMapping
    ResponseEntity<Page<VehicleSummaryResponse>> search(
            @Schema(implementation = PageParamRequest.class)
            @PageableDefault(size = 20)
            Pageable pageable);

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    ResponseEntity<Void> delete(@PathVariable String id);

    @PatchMapping("{id}")
    ResponseEntity<VehicleDetailedResponse> update(@PathVariable String id, @RequestBody Map<String, Object> fields);
}
