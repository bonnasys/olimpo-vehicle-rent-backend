package br.com.bonnasys.olimpo.cities.app.rest.controller;

import br.com.bonnasys.olimpo.cities.app.rest.CityApi;
import br.com.bonnasys.olimpo.cities.app.rest.dto.CityResponse;
import br.com.bonnasys.olimpo.cities.app.rest.dto.request.CreateCityRequest;
import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.cities.domain.usecases.CityFacade;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@AllArgsConstructor
public class CityController implements CityApi {
    private final CityFacade cityFacade;

    @Override
    public ResponseEntity<Page<CityResponse>> search(Pageable pageable) {
        Page<City> cityPage = cityFacade.search(pageable);
        Page<CityResponse> response = cityPage.map(it -> new CityResponse(it.getId(), it.getName(), it.getState()));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> create(CreateCityRequest request) {
        City city = cityFacade.createCityUseCase(new City());
        return ResponseEntity.created(fromCurrentRequest()
                        .path("/{id}").buildAndExpand(city.getId()).toUri())
                .build();
    }
}
