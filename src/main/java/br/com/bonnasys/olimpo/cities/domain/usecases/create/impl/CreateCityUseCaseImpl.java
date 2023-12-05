package br.com.bonnasys.olimpo.cities.domain.usecases.create.impl;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.cities.domain.repository.CityRepository;
import br.com.bonnasys.olimpo.cities.domain.usecases.create.CreateCityUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateCityUseCaseImpl implements CreateCityUseCase {
    private final CityRepository cityRepository;

    @Override
    public City invoke(City city) {
        return cityRepository
                .findByNameAndState(city.getName(), city.getState())
                .orElseGet(() -> cityRepository.save(city));
    }
}
