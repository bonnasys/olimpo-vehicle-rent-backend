package br.com.bonnasys.olimpo.cities.domain.repository;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, String> {
    Optional<City> findByNameAndState(String name, String state);
}
