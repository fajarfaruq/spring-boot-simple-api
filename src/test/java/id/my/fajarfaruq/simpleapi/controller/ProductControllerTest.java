package id.my.fajarfaruq.simpleapi.controller;

import id.my.fajarfaruq.simpleapi.model.Product;
import java.math.BigDecimal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/** ProductControllerTest Class. This class using for test Product Controller method on main application
 *
 * @author Fajar Faruq
 */

// Test spring boot using random port not only default port 8080
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ProductControllerTest {
    
    // @LocalServerPort is just a shortcut for @Value("${local.server.port}")
    @LocalServerPort
    private int port;
    
    // @Autowired annotation is used for dependency injection. for this cas pretend to productRepository
    @Autowired
    private TestRestTemplate restTemplate;
    
    // This method test case using for test get all payload product and the result should be return all product
    @Test
    void givenProduct_GetAllProductsEndpoint_ShouldReturnProductList() {
        String baseUrl = "http://localhost:" + port + "/api/v1/products";
        ResponseEntity<Product[]> response = restTemplate.getForEntity(baseUrl, Product[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
    // This method test case using for create a new product and the result should be add a new product
    @Test
    void givenANewProduct_PostProductsEndpoint_ShouldAddNewProduct() {
        String baseUrl = "http://localhost:" + port + "/api/v1/products";
        Product product = new Product();
        product.setName("TV TCL 50 Inch");
        product.setDescription("Television TCL 50 Inch Smart TV");
        product.setPrice(BigDecimal.valueOf(5000000.00));

        ResponseEntity<Product> response = restTemplate.postForEntity(baseUrl, product, Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
    // This test case using for get product id and the result should be return the product by id 
    @Test
    void givenProduct_GetProductsByIdEndpoint_ShouldReturnProductById() {
        String baseUrl = "http://localhost:" + port + "/api/v1/products/1";
        ResponseEntity<Product> response = restTemplate.getForEntity(baseUrl, Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
    // This method test case using for update a product by id and the result payload sent into api should be updated also into product table by id
    @Test
    void givenUpdateAProduct_PutProductsEndpoint_ShouldUpdateAProduct() {
        String baseUrl = "http://localhost:" + port + "/api/v1/products/1";

        Product product = restTemplate.getForObject(baseUrl, Product.class);
        product.setName("TV TCL 32 Inch");
        product.setDescription("Television TCL 32 Inch Smart TV");
        product.setPrice(BigDecimal.valueOf(2500000.00));

        restTemplate.put(baseUrl, product);

        ResponseEntity<Product> response = restTemplate.getForEntity(baseUrl, Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    // This method case using for delete product by id and the result should delete a product by id
    @Test
    void givendeleteAProduct_DeleteProductsEndpoint_ShouldDeleteAProduct() {
        String baseUrl = "http://localhost:" + port + "/api/v1/products/1";
        ResponseEntity<Product> response = restTemplate.getForEntity(baseUrl, Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        
        Product product = restTemplate.getForObject(baseUrl, Product.class);
        restTemplate.delete(baseUrl, product);

        response = restTemplate.getForEntity(baseUrl, Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
