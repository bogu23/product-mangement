package bogu.spring.productmanagement2.repository;

import bogu.spring.productmanagement2.entities.ManufacturerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerModel, Long> {

}
