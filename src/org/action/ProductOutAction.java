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

public class ProductOutAction extends ActionSupport{
	ProductOutDao productOutDao;
	ProductOut productOutBean;
	ProductDao productDao;
	private File photoFile;
	private ProductOut productOut;
	
	public ProductOut getProductOut() {
		return productOut;
	}
	public void setProductOut(ProductOut productOut) {
		this.productOut = productOut;
	}
		
	public ProductOut getProductOutBean() {
		return productOutBean;
	}
	public void setProductOutBean(ProductOut productOutBean) {
		this.productOutBean = productOutBean;
	}
	public String execute()throws Exception{
		ProductOutDao productOutDao = new ProductOutDaoImp();
		List prodOut_list = productOutDao.getAll();	
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("prodOut_list", prodOut_list);		
		return SUCCESS;
	}
	
	public String update() throws Exception{
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
        ProductOut prodOut = (ProductOut) Hsession.load(ProductOut.class, productOut.getId());
		
		try{
			productOutDao=new ProductOutDaoImp();
			
			prodOut.setStatus("Delivered");
			
			Hsession.update(prodOut);					
			ts.commit();
			
			//productOutDao.update(prod);
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
	}
	
	public String getAllProduct() {
		ProductOutDao productOutDao=new ProductOutDaoImp();
		List prodOut_list=productOutDao.getAll();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodOut_list", prodOut_list);		
		return SUCCESS;
	}
	
	public String getAllOnShippingProduct() {
		ProductOutDao productOutDao=new ProductOutDaoImp();
		List prodOut_list=productOutDao.getOnShipping();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodOut_list", prodOut_list);		
		return SUCCESS;
	}
	
	public String addNewProductSold() {
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
		SessionFactory sessionFactory2 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession2=sessionFactory2.openSession();		
		Transaction ts2 = Hsession2.beginTransaction();
		
		ProductOut productOut = new ProductOut();
		Product prod = new Product();

		try{
			productDao = new ProductDaoImp();
			//Product product=productDao.getOneProduct(Integer.parseInt(productInBean.getProd_id()));
			//Product product = (Product) Hsession2.get(Product.class, Integer.parseInt(productInBean.getProd_id()));
			Product productInTheDatabase=productDao.getOneProduct(productOutBean.getProd_id());
			if(productInTheDatabase!=null){
				
				prod.setId(productInTheDatabase.getId());
				prod.setProd_id(productInTheDatabase.getProd_id());
				prod.setCategory(productInTheDatabase.getCategory());
				prod.setProd_name((productInTheDatabase.getProd_name()));
				prod.setProd_img(productInTheDatabase.getProd_img());
				
				if(productInTheDatabase.getIn_stock() < productOutBean.getQuantity() || productInTheDatabase.getIn_stock() == 0) {
					return ERROR;
				}
				else {
					prod.setIn_stock(productInTheDatabase.getIn_stock()-productOutBean.getQuantity());
				}
				
				prod.setPending_stock(productInTheDatabase.getPending_stock());
				prod.setDescription(productInTheDatabase.getDescription());
				
				Hsession2.update(prod);
				ts2.commit();
				
			}
			
			System.out.println(productOutBean.getBuyer());
			
			productOut.setProd_id(productOutBean.getProd_id());
			productOut.setBuyer(productOutBean.getBuyer());
			
			System.out.println(productOut.getBuyer());
			productOut.setQuantity(productOutBean.getQuantity());
			productOut.setSelling_price(productOutBean.getSelling_price());
			productOut.setStatus(productOutBean.getStatus());
			productOut.setDate(new Date(System.currentTimeMillis()));
			
			Hsession.save(productOut);
			ts.commit();

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
		
	}
}
