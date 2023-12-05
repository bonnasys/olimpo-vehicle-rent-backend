package br.com.bonnasys.olimpo.cities.domain.usecases.search.impl;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.cities.domain.repository.CityRepository;
import br.com.bonnasys.olimpo.cities.domain.usecases.search.SearchCityUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchCityUseCaseImpl implements SearchCityUseCase {
    private final CityRepository cityRepository;

    @Override
    public Page<City> invoke(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

}
