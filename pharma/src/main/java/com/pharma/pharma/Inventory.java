package com.pharma.pharma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inventory")
public class Inventory {
	@Column(name = "Qty")
	Integer Qty;
	@Column(name = "productid")
	Integer productid;
	
	public Integer getName() {
		return productid;
	}
	public void setName(Integer Qty) {
		this.Qty = Qty;
	}
	
	public Integer getProductid() {
		return productid;
	}
	
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	
}
