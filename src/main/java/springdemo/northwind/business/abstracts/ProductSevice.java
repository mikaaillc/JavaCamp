package springdemo.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import springdemo.northwind.core.utilities.results.DataResult;
import springdemo.northwind.core.utilities.results.Result;
import springdemo.northwind.entities.concretes.Product;
import springdemo.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductSevice {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted();
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	Result add(Product product);

	DataResult<Product> getByProductName(String productName);//getby görüp ilgili kolona göre where koşulu gelir

	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	// select * from products where category_id in(1,2,3)
	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategoryId(String productName,int categoryId);

	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
