package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.impl.*;
import org.dao1.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.model.*;
import com.opensymphony.xwork2.*;

public class ProductInAction extends ActionSupport{
	ProductInDao productInDao;
	ProductDao productDao;
	
	private Product productBean;
	private ProductIn productInBean;
	private ProductIn prodIn;
	
	private File photoFile;
	
	public File getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}
	
	
	public ProductIn getProductInBean() {
		return productInBean;
	}
	public void setProductInBean(ProductIn productInBean) {
		this.productInBean = productInBean;
	}
	public ProductIn getProdIn() {
		return prodIn;
	}
	public void setProdIn(ProductIn prodIn) {
		this.prodIn = prodIn;
	}
	
	public Product getProductBean() {
		return productBean;
	}
	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}
	
	
	public String update() throws Exception{
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
		ProductDao productDaoForId = new ProductDaoImp();
		Product prodById = productDaoForId.getOneProduct(prodIn.getProd_id());
		
		ProductInDao productInDaoForId = new ProductInDaoImp();
		ProductIn prodInById = productInDaoForId.getOneProductInByProd_id(prodIn.getProd_id(), prodIn.getId());
		
        ProductIn productIn = (ProductIn) Hsession.load(ProductIn.class, prodInById.getId());
        Product product = (Product) Hsession.load(Product.class, prodById.getId());
		
        if((productIn.getStatus()).equals("On shipping")) {
			try{
				productInDao=new ProductInDaoImp();
				
				product.setIn_stock(product.getIn_stock()+productIn.getQuantity());
				product.setPending_stock(product.getPending_stock()-productIn.getQuantity());
				productIn.setStatus("Arrived");
				
				Hsession.update(product);					
				Hsession.update(productIn);					
				ts.commit();
				Hsession.clear();
				Hsession.close();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
								
			}
		
			if(valid){
				return getAllProduct();
			}
			else{
				return ERROR;
			}
        }else {
        	return getAllProduct();
        }
	}
	
	public String getAllProduct() {
		ProductInDao productInDao=new ProductInDaoImp();
		List prodIn_list=productInDao.getAll();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodIn_list", prodIn_list);		
		return SUCCESS;
	}
	
	public String getAllOnShippingProduct() {
		ProductInDao productInDao=new ProductInDaoImp();
		List prodIn_list=productInDao.getOnShipping();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodIn_list", prodIn_list);		
		return SUCCESS;
	}
	
	public String addNewPurchase() throws Exception{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
		ProductIn productIn = new ProductIn();
		Product prod = new Product();
		try{
			productDao = new ProductDaoImp();
			Product productInTheDatabase=productDao.getOneProduct(productInBean.getProd_id());
			if(productInTheDatabase!=null){
				
				prod.setId(productInTheDatabase.getId());
				prod.setProd_id(productInTheDatabase.getProd_id());
				prod.setCategory(productInTheDatabase.getCategory());
				prod.setProd_name((productInTheDatabase.getProd_name()));
				prod.setProd_img(productInTheDatabase.getProd_img());
				prod.setDescription(productInTheDatabase.getDescription());
				
				if(productInBean.getStatus().equals("Arrived")) {
					prod.setIn_stock(productInTheDatabase.getIn_stock()+productInBean.getQuantity());
					prod.setPending_stock(productInTheDatabase.getPending_stock());
				}
				else {
					prod.setIn_stock(productInTheDatabase.getIn_stock());
					prod.setPending_stock(productInTheDatabase.getPending_stock()+productInBean.getQuantity());
				}
				
				Hsession.update(prod);
				
			}
			else{
				
				prod.setProd_id(productInBean.getProd_id());
				prod.setProd_name(productBean.getProd_name());
				prod.setCategory(productBean.getCategory());
				if(this.getPhotoFile()!=null){
					FileInputStream fis=new FileInputStream(this.getPhotoFile());	
					byte[] buffer=new byte[fis.available()];	
					fis.read(buffer);					
					prod.setProd_img(buffer);
				}
				prod.setDescription(productBean.getDescription());
				
				if(productInBean.getStatus().equals("Arrived")) {
					prod.setIn_stock(productInBean.getQuantity());
					prod.setPending_stock(0);
				}
				else {
					prod.setIn_stock(0);
					prod.setPending_stock(productInBean.getQuantity());
				}
				
				Hsession.save(prod);
			}
			
			productIn.setProd_id(productInBean.getProd_id());
			productIn.setSupplier(productInBean.getSupplier());
			productIn.setQuantity(productInBean.getQuantity());
			productIn.setBuying_price(productInBean.getBuying_price());
			productIn.setStatus(productInBean.getStatus());
			productIn.setDate(new Date(System.currentTimeMillis()));
			
			Hsession.save(productIn);
			ts.commit();
			
			Hsession.clear();
			Hsession.close();
			return getAllProduct();
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;				
		}

	}
}
