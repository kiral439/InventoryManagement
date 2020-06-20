package org.model;
import java.util.*;
/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */
public class Product{
	//Fields
	private Integer id;
	private String prod_id;
	private String category;
	private String prod_name;
	private byte[] prod_img;
	private Integer stock;
	private String description;

//	private Set course_set = new HashSet();	
	//Constructors
	/** default constructor */
	public Product() {
	}
	/** minimal constructor */
	public Product(String prod_id,String category, String prod_name, Integer stock) {
		this.prod_id = prod_id;
		this.category = category;
		this.prod_name = prod_name;
		this.stock = stock;
	}
	/** full constructor */
	public Product(Integer id, String prod_id, String category, String prod_name, byte[] prod_img, Integer stock,
			String description) {
		super();
		this.id=id;
		this.prod_id = prod_id;
		this.category = category;
		this.prod_name = prod_name;
		this.prod_img = prod_img;
		this.stock = stock;
		this.description = description;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public byte[] getProd_img() {
		return prod_img;
	}
	public void setProd_img(byte[] prod_img) {
		this.prod_img = prod_img;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
