package br.com.bonnasys.olimpo.reserves.domain.model;

import br.com.bonnasys.olimpo.users.domain.model.Client;
import br.com.bonnasys.olimpo.vehicles.domain.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "reserves")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_vehicle",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_reserve_vehicle"))
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "id_client",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_reserve_client"))
    private Client client;
}
