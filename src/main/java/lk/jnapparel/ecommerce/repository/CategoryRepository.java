package lk.jnapparel.ecommerce.repository;

import lk.jnapparel.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
