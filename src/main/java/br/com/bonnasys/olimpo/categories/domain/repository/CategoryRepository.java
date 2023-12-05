package br.com.bonnasys.olimpo.categories.domain.repository;

import br.com.bonnasys.olimpo.categories.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
