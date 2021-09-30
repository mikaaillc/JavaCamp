package springdemo.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import springdemo.northwind.entities.concretes.Product;
import springdemo.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>{
    Product getByProductName(String productName);//getby görüp ilgili kolona göre where koşulu gelir

    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
    // select * from products where category_id in(1,2,3)
    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory_CategoryId(String productName,int categoryId);

    @Query(" Select new springdemo.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner JOIN c.products p ")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //select * from Category c innerjoin Product p on c.category = p.categoryId
 }
