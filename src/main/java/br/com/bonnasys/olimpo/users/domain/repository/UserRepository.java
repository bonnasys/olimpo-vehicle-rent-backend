package br.com.bonnasys.olimpo.users.domain.repository;

import br.com.bonnasys.olimpo.users.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
