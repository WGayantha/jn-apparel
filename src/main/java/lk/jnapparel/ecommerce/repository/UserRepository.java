package lk.jnapparel.ecommerce.repository;

import lk.jnapparel.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
