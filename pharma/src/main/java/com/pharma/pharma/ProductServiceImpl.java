package com.pharma.pharma;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements AppService {

	@Autowired
	private ProductRepo prepo;
	@Autowired
	private CategoryRepo crepo;

	public List<Product> getProducts() {
		return prepo.findAll();
	}

	public Optional<Product> getProduct(Integer id) {
		return prepo.findById(id);
	}
	
	public List<Category> getCategories() {
		return crepo.findAll();
	}

	public Optional<Category> getCategory(Integer id) {
		return crepo.findById(id);
	}
	
public String addProductToCategory(Product std,  Integer categoryid) {
		
		Optional<Category> category = crepo.findById(categoryid);
		if(category.isPresent() == false)
			return "Category Absent in db";
		category.get().addProducts(std);
		crepo.saveAndFlush(category.get());
		return "Successfully added product to category";
	}
	
	public String addCategoryToProduct(Category cors, Integer productid) {
		
		Optional<Product> product = prepo.findById(productid);
		if(product.isPresent() == false)
		{
			return "Product id not present";
		}
		product.get().setCategory(cors);
		prepo.saveAndFlush(product.get());
		return "Category add to Product successfully";
	}
	
	public String removeProductFromCategory(Integer productid) {
		
			crepo.deleteById(productid);
			return "Deletion of Product from category done";
	}	
	
	// TODO - Remove a course from the student
}

