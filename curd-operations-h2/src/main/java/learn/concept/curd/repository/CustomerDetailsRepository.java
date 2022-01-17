package learn.concept.curd.repository;

import learn.concept.curd.model.CustomerDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository
        extends JpaRepository<CustomerDetailsEntity, Long> {
 
}
