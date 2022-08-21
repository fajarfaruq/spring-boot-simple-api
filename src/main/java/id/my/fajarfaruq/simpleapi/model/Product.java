package id.my.fajarfaruq.simpleapi.model;

import com.sun.istack.NotNull;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Product Class. This class using for represent field of table product
 * 
 * @author Fajar Faruq
 */
@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id; 
    
    @Column(name = "name", nullable = false)
    @NotNull
    private String name;
    
    @Column(name = "description", nullable = false)
    @NotNull
    private String description;
    
    @Column(name = "price", nullable = false)
    @NotNull
    private BigDecimal price;
    
    /**
     * getId method. using for get id 
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * setId method. using for set id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getName method. using for get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setName method. using for set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getDescription method. using for get description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription method. using for set description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getPrice method. using for get price
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * setPrice method. using for set price
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
