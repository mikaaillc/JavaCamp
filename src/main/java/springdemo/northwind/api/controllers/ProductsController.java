package springdemo.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springdemo.northwind.business.abstracts.ProductSevice;
import springdemo.northwind.core.utilities.results.DataResult;
import springdemo.northwind.core.utilities.results.Result;
import springdemo.northwind.entities.concretes.Product;
import springdemo.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("api/products")//
public class ProductsController {
	@Autowired
	private ProductSevice productService;
	
	// fake neseneler oluşturup unit testler için service kullanılıor
	public ProductsController(ProductSevice productService) {//productmanager productservice si implemete ettiği için aslında product manager elimize geliyor
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getALl(){
		return this.productService.getAll();

	}
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}

	@GetMapping("/getByProductName")//yapılan isteğin parametreleri oku
	public DataResult<Product>getByProductName(@RequestParam  String productName){
		return this.productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product>getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName,categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getALl(int pageNo,int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}

}