package bogu.spring.productmanagement2.repository;

import bogu.spring.productmanagement2.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    @Query("select product from ProductModel product order by product.name")
    List<ProductModel> getProductsOrderedByName();


}
