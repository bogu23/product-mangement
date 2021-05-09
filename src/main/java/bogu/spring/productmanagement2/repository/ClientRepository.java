package bogu.spring.productmanagement2.repository;

import bogu.spring.productmanagement2.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

}
