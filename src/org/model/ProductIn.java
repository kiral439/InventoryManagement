package org.model;
import java.util.*;
/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */
public class ProductIn{
	private Integer id;
	private String prod_id;
	private String supplier;
	private Integer quantity;
	private Double buying_price;
	private String status;

	private Date date;
	/** default constructor */
	public ProductIn() {
	}
	/** full constructor */
	public ProductIn(String prod_id, String supplier, Integer quantity, Double buying_price, String status, Date date) {
		super();
		this.prod_id = prod_id;
		this.supplier = supplier;
		this.quantity = quantity;
		this.buying_price = buying_price;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getBuying_price() {
		return buying_price;
	}
	public void setBuying_price(Double buying_price) {
		this.buying_price = buying_price;
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
