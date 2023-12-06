package br.com.bonnasys.olimpo.users.domain.model;

import br.com.bonnasys.olimpo.cities.domain.model.City;
import br.com.bonnasys.olimpo.reserves.domain.model.Reserve;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users_clients")
@JsonTypeName("CLIENT")
@DiscriminatorValue(value = "CLIENT")
@PrimaryKeyJoinColumn(name = "id",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(name = "fk_client_user"))
public class Client extends User {


    @ManyToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "fk_clients_city"))
    private City city;

    @OneToMany(mappedBy = "client")
    private List<Reserve> reserves;

}
