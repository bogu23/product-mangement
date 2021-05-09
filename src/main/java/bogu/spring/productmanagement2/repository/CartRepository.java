package bogu.spring.productmanagement2.repository;

import bogu.spring.productmanagement2.entities.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartModel, Long> {
}
