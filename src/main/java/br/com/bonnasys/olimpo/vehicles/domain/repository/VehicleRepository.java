package br.com.bonnasys.olimpo.vehicles.domain.repository;

import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
