package lk.jnapparel.ecommerce.repository;

import lk.jnapparel.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
