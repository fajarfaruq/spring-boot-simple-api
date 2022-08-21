package id.my.fajarfaruq.simpleapi.controller;

import id.my.fajarfaruq.simpleapi.exception.ResourceNotFoundException;
import id.my.fajarfaruq.simpleapi.model.Product;
import id.my.fajarfaruq.simpleapi.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** ProductController Class. This class using for control CRUD API Product operation  
 *
 * @author Fajar Faruq
 */
@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * getAllProduct method. This method using for get all product 
     * @return List<Product> 
     */
    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    /**
     * getProductbyId method. This method using for get product by id
     * @param productId Product id parameter
     * @return Array of product
     * @throws ResourceNotFoundException Error not found handler
     */
    @GetMapping("/products/{id}")
    public ResponseEntity getProductbyId(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(()
                -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    /**
     * createProduct method. This method using for create a new product 
     * @param product The parameter is array of product in payload write with JSON
     * @return Array of new product
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    /**
     * updateProduct method. This method using for update an existing product by id
     * @param productId Product id parameter
     * @param productDetails Array of product except id in payload write with JSON
     * @return Array of updated product
     * @throws ResourceNotFoundException Error not found handler
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
            @Validated @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(()
                -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        final Product updateProduct = productRepository.save(product);
        return ResponseEntity.ok(updateProduct);

    }

    /**
     * deleteProduct method. This method using for delete a product by id
     * @param productId This method using for update an existing product by id
     * @return If success should be return array boolean = true
     * @throws ResourceNotFoundException Error not found handler
     */
    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(()
                -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
