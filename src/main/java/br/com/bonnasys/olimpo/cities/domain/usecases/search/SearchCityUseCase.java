package br.com.bonnasys.olimpo.cities.domain.usecases.search;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchCityUseCase {

    Page<City> invoke(Pageable pageable);
}
