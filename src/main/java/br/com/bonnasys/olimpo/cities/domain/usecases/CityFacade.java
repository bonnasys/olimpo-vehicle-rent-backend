package br.com.bonnasys.olimpo.cities.domain.usecases;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.cities.domain.usecases.create.CreateCityUseCase;
import br.com.bonnasys.olimpo.cities.domain.usecases.search.SearchCityUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CityFacade {
    private final CreateCityUseCase createCityUseCase;
    private final SearchCityUseCase searchCityUseCase;

    public Page<City> search(Pageable page) {
        return searchCityUseCase.invoke(page);
    }

    public City createCityUseCase(City city) {
        return createCityUseCase.invoke(city);
    }
}
