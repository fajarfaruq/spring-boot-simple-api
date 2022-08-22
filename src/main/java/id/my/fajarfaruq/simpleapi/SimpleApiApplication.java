package id.my.fajarfaruq.simpleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot Simple API Main Class. This class using for define main class of
 * simple API
 *
 * @author Fajar Faruq
 */
@SpringBootApplication
@EnableSwagger2
public class SimpleApiApplication {

    /**
     * Spring Boot Simple API main method. This part using for define main
     * method
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(SimpleApiApplication.class, args);
    }
    
    @Bean
    public Docket productApi() {
       return new Docket(DocumentationType.SWAGGER_2).select()
          .apis(RequestHandlerSelectors.basePackage("id.my.fajarfaruq.simpleapi.controller")).build();
    }

}
