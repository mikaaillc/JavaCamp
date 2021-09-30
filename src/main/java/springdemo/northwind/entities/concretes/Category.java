package springdemo.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})// sosuz sorgu oluşmasını engeller
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy="category") // aralarındaki ilişki
    private List<Product> products;
}
