package bogu.spring.productmanagement2.repository;

import bogu.spring.productmanagement2.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {


}
