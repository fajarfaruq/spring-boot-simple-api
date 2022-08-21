package id.my.fajarfaruq.simpleapi.repository;

import id.my.fajarfaruq.simpleapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends  JpaRepository<Product, Long>{
    
}
