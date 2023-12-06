package br.com.bonnasys.olimpo.users.domain.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users_employees")
@JsonTypeName("EMPLOYEE")
@DiscriminatorValue(value = "EMPLOYEE")
@PrimaryKeyJoinColumn(name = "id",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(name = "fk_employee_user"))
public class Employee extends User {

    private String registration;

    @ManyToOne
    @JoinColumn(name = "user_role", foreignKey = @ForeignKey(name = "fk_employee_role"))
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()), new SimpleGrantedAuthority(getType().name()));
    }
}
