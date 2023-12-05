package br.com.bonnasys.olimpo.cities.app.rest;

import br.com.bonnasys.olimpo.cities.app.rest.dto.CityResponse;
import br.com.bonnasys.olimpo.cities.app.rest.dto.openapi.CityPageResponseOpenApi;
import br.com.bonnasys.olimpo.cities.app.rest.dto.request.CreateCityRequest;
import br.com.bonnasys.olimpo.common.openapi.model.request.PageParamRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Cities")
@RequestMapping("cities")
public interface CityApi {

    @GetMapping
    @ApiResponse(responseCode = "200",
            content = @Content(schema = @Schema(implementation = CityPageResponseOpenApi.class)))
    ResponseEntity<Page<CityResponse>> search(@Schema(implementation = PageParamRequest.class)
                                              @PageableDefault
                                              Pageable pageable);

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    ResponseEntity<Void> create(@RequestBody @Valid CreateCityRequest request);
}
