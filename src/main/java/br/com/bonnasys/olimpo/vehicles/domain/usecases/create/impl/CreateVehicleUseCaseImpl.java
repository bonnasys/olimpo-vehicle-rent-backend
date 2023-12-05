package br.com.bonnasys.olimpo.vehicles.domain.usecases.create.impl;

import br.com.bonnasys.olimpo.categories.domain.Category;
import br.com.bonnasys.olimpo.categories.domain.repository.CategoryRepository;
import br.com.bonnasys.olimpo.characteristics.domain.model.Characteristic;
import br.com.bonnasys.olimpo.characteristics.domain.repository.CharacteristicRepository;
import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.cities.domain.repository.CityRepository;
import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;
import br.com.bonnasys.olimpo.vehicles.domain.repository.VehicleRepository;
import br.com.bonnasys.olimpo.vehicles.domain.usecases.create.CreateVehicleUseCase;
import br.com.bonnasys.olimpo.vehicles.domain.usecases.create.command.CreateVehicleCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CreateVehicleUseCaseImpl implements CreateVehicleUseCase {
    private final VehicleRepository vehicleRepository;
    private final CharacteristicRepository characteristicRepository;
    private final CityRepository cityRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Vehicle invoke(CreateVehicleCommand command) {
        String categoryId = command.categoryId();
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        Set<String> characteristicIds = command.characteristicIds();
        Set<Characteristic> characteristics = characteristicRepository.findAllByIdIn(characteristicIds);

        String cityId = command.cityId();
        City city = cityRepository.findById(cityId).orElseThrow();

        Vehicle vehicle = command.vehicle();
        vehicle.setCategory(category);
        vehicle.setCharacteristics(characteristics);
        vehicle.setCity(city);

        return vehicleRepository.save(vehicle);
    }
}
