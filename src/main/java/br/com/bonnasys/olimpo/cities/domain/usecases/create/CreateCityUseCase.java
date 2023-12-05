package br.com.bonnasys.olimpo.cities.domain.usecases.create;

import br.com.bonnasys.olimpo.cities.domain.model.City;

public interface CreateCityUseCase {

    City invoke(City city);

}
