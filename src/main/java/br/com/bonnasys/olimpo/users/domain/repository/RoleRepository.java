package br.com.bonnasys.olimpo.users.domain.repository;

import br.com.bonnasys.olimpo.users.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findRoleByName(String name);
}
