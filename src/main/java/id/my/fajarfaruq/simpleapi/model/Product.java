package id.my.fajarfaruq.simpleapi.model;

import com.sun.istack.NotNull;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
