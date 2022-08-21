package id.my.fajarfaruq.simpleapi.repository;

import id.my.fajarfaruq.simpleapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/** ProductRepository Class. This class using for encapsulating storage, retrieval, and search behavior which emulates a collection of objects of product
 *
 * @author Fajar Faruq
 */
public interface ProductRepository extends  JpaRepository<Product, Long>{
    
}
