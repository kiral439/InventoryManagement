package org.model;
import java.util.*;
/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */
public class ProductOut{
	//Fields
	private Integer id;
	private String prod_id;
	private String buyer;
	private Integer quantity;
	private Double selling_price;
	private String status;
	private Date date;
	/** default constructor */
	public ProductOut() {
	}
	/** full constructor */
	public ProductOut(Integer id, String prod_id, String buyer, Integer quantity, Double selling_price, String status, Date date) {
		super();
		this.id = id;
		this.prod_id = prod_id;
		this.buyer = buyer;
		this.quantity = quantity;
		this.selling_price = selling_price;
		this.status = status;
		this.date = date;
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
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(Double selling_price) {
		this.selling_price = selling_price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
}
