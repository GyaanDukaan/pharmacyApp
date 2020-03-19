package com.pharma.pharma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medicine")
public class Medicine {
	@Column(name = "MedicineName")
	String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "productid")
	Integer productid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getProductid() {
		return productid;
	}
	
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	
}
