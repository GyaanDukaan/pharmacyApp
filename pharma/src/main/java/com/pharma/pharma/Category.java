package com.pharma.pharma;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@Column(name = "id")
	Integer id;
	@Column(name = "CategoryName")
    String category;	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getCategoryName(String name)
	{
	   return category;
	}
	public void setCategoryName(String category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy="id",
			   orphanRemoval = true,
			   cascade= CascadeType.ALL,
			   fetch = FetchType.EAGER) // default is Lazy
	@JsonManagedReference
	private List<Product> product;

	public List<Product> getCourses() {
		return product;
	}

	public void setProducts(List<Product> products) {
		this.product = products;
	}
	
	// add convenience methods for bi-directional relationship

	public void addProducts(Product tempProduct) {
		
		if (product == null) {
			product = new ArrayList<>();
		}
	
		if(product.contains(tempProduct))
			return;
		
		product.add(tempProduct);
		
		/* We are setting the newly created instructor class to the course object 
		 * to create a relationship between them.
		 */
		tempProduct.setCategory(this);
	
	}
}
