package br.com.bonnasys.olimpo.vehicles.domain.model;

import br.com.bonnasys.olimpo.categories.domain.Category;
import br.com.bonnasys.olimpo.characteristics.domain.model.Characteristic;
import br.com.bonnasys.olimpo.cities.domain.model.City;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import reserves.domain.model.Reserve;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String model;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_category_vehicle"))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_city_vehicle"))
    private City city;


    @OneToMany
    @JoinColumn(name = "vehicle_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_vehicle_reserves"))
    private Set<Reserve> reserves;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "vehicles_characteristics",
            joinColumns = @JoinColumn(name = "id_vehicle",
                    foreignKey = @ForeignKey(name = "fk_vehicle_characteristic")),
            inverseJoinColumns = @JoinColumn(name = "id_characteristic",
                    foreignKey = @ForeignKey(name = "fk_characteristic_vehicle"))
    )
    private Set<Characteristic> characteristics;
}
