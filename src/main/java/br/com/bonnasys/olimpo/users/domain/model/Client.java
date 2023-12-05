package br.com.bonnasys.olimpo.users.domain.model;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users_clients")
@JsonTypeName("CLIENT")
@DiscriminatorValue(value = "CLIENT")
public class Client extends User {

    @ManyToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "fk_users_clients_city"))
    private City city;

}
