package com.pharma.pharma;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/productservices")
public class ProductController implements AppService {

	@Autowired ProductServiceImpl productServiceImpl;

	@RequestMapping("/products")
	public List<Product> getProducts() {
		return productServiceImpl.getProducts();
	}

	@RequestMapping("/products/{id}")
	public Optional<Product> getProducts(@PathVariable("id")Integer id) {
		return productServiceImpl.getProduct(id);
	}
	
	@RequestMapping("/categories")
	public List<Category> getCategories() {
		return productServiceImpl.getCategories();
	}

	@RequestMapping("/categories/{id}")
	public Optional<Category> getCategories(@PathVariable("id")Integer id) {
		return productServiceImpl.getCategory(id);
	}
	
	@RequestMapping(value = "/addProductToCategory",method = RequestMethod.POST)
public String addProductToCategory(Product std, @RequestParam("categoryid") Integer categoryid) {
		
		Optional<Category> category = productServiceImpl.getCategory(categoryid);
		if(category.isPresent() == false)
			return "Category Absent in db";
		category.get().addProducts(std);
		productServiceImpl.addProductToCategory(std,categoryid);
		return "Successfully added product to category";
	}
	
	@RequestMapping(value = "/addCategoryToProduct",method = RequestMethod.POST)
	public String addCategoryToProduct(Category cors, @RequestParam("productid") Integer productid) {
		
		productServiceImpl.addCategoryToProduct(cors,productid);
		return "Category add to Product successfully";
	}
	
	@RequestMapping(value = "/removeProductFromCategory/{id}",method = RequestMethod.DELETE)
	public String removeProductFromCategory(@RequestParam("id")Integer productid) {
		
			productServiceImpl.removeProductFromCategory(productid);
			return "Deletion of Product from category done";
	}	
	
	// TODO - Remove a course from the student
}


