package com.pharma.pharma;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Inventory")
public class Inventory {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "unit")
	Integer Qty;
	@Column(name = "productid")
	Integer productid;
	
	@Column(name ="is_available")
	private Boolean isAvailable;
	@Column(name ="created")
	private Date created;
	@Column(name ="updated")
	private Date updated;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQty()
	{
		return Qty;
	}
	public Integer getId() {
		return id;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public void setAvailability(Boolean available) 
	{
		isAvailable = available;
	}
	public Date getUpdated() {
		return updated;
	}
	
	public void setCreated(Date created)
	{
	   this.created = created;
	}
	
	
	
	public Integer getProductId() {
		return productid;
	}
	
	public void setQuantity(Integer Qty) {
		this.Qty = Qty;
	}
	
	public Integer getProductid() {
		return productid;
	}
	
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	@OneToOne(mappedBy = "inventory", cascade = CascadeType.ALL)
    private Product prod;
	
	
}
