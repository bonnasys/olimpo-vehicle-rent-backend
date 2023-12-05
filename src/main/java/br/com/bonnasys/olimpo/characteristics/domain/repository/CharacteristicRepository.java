package br.com.bonnasys.olimpo.characteristics.domain.repository;

import br.com.bonnasys.olimpo.characteristics.domain.model.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CharacteristicRepository extends JpaRepository<Characteristic, String> {

    Set<Characteristic> findAllByIdIn(Set<String> ids);
}
