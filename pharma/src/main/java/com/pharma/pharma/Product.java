package com.pharma.pharma;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="productName")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	@Column(name = "image")
	private String imagePath;
	
	@Column(name = "title")
	private String title;
	
	@Column(name ="created")
	private Date created;
	
	@Column(name = "updated")
	private Date updated;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH},
			
						 fetch = FetchType.EAGER)
	@JoinColumn(name="productid")
	@JsonBackReference
	private Category category;
	
	public void setCategory(Category category)
	{
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

   public void setCreated(Date created)
   {
	   this.created = created;
   }
   public Date getCreated()
   {
	   return created;
   }
   public void setUpdated(Date d)
   {
	   updated = d;
	   
   }	
   
   public Date getUpdated()
   {
	   return updated;
   }
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + "]";
	}
	
}
