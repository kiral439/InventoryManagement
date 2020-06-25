package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import org.dao.impl.CategoryDaoImp;
import org.dao.impl.ProductDaoImp;
import org.dao.impl.ProductInDaoImp;
import org.dao.impl.ProductOutDaoImp;
import org.dao1.CategoryDao;
import org.dao1.ProductDao;
import org.dao1.ProductInDao;
import org.dao1.ProductOutDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.model.Product;
import org.model.ProductIn;
import org.model.ProductOut;

import com.opensymphony.xwork2.*;

public class ProductEditAction {
	private ProductDao productDao;
	private ProductDao productDao2;
	private ProductInDao prodInDao;
	private ProductIn prodIn;
	
	private ProductOutDao prodOutDao;
	private ProductOut prodOut;
	
	private ProductOut productOutBean;
	
	private ProductIn productInBean;
	private Product productBean;
	
	private File photoFile;
	
	public File getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}

	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public ProductDao getProductDao2() {
		return productDao2;
	}
	public void setProductDao2(ProductDao productDao2) {
		this.productDao2 = productDao2;
	}
	
	public ProductInDao getProdInDao() {
		return prodInDao;
	}
	public void setProdInDao(ProductInDao prodInDao) {
		this.prodInDao = prodInDao;
	}

	public ProductIn getProdIn() {
		return prodIn;
	}
	public void setProdIn(ProductIn prodIn) {
		this.prodIn = prodIn;
	}
	
	
	public ProductOutDao getProdOutDao() {
		return prodOutDao;
	}
	public void setProdOutDao(ProductOutDao prodOutDao) {
		this.prodOutDao = prodOutDao;
	}
	public ProductOut getProdOut() {
		return prodOut;
	}
	public void setProdOut(ProductOut prodOut) {
		this.prodOut = prodOut;
	}
	
	
	public ProductOut getProductOutBean() {
		return productOutBean;
	}
	public void setProductOutBean(ProductOut productOutBean) {
		this.productOutBean = productOutBean;
	}
	public ProductIn getProductInBean() {
		return productInBean;
	}
	public void setProductInBean(ProductIn productInBean) {
		this.productInBean = productInBean;
	}
	
	public Product getProductBean() {
		return productBean;
	}
	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}
	
	public String execute() throws Exception{
		productDao=new ProductDaoImp();
		Product prod_list=productDao.getOneProduct(prodIn.getProd_id());			
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prod_list", prod_list);		
		
		prodInDao=new ProductInDaoImp();
		ProductIn prodIn_list=prodInDao.getOneProductIn(prodIn.getId());	
		request.put("prodIn_list", prodIn_list);
		
		CategoryDao categoryDao=new CategoryDaoImp();				
		List categories=categoryDao.getAll();
		if(categories!=null){					
			request.put("categories", categories);
		}
		return "success";
	}
	
	public String getProductOutInfo() throws Exception{
		productDao=new ProductDaoImp();
		Product prod_list=productDao.getOneProduct(prodOut.getProd_id());			
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prod_list", prod_list);
		
		prodOutDao=new ProductOutDaoImp();
		ProductOut prodOut_list=prodOutDao.getOneProductOut(prodOut.getId());	
		request.put("prodOut_list", prodOut_list);
		
		return "success";
	}
		
	public String updateIn() throws Exception{
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
        ProductIn productIn = new ProductIn();
        Product product = new Product();
        
		try{
			productDao=new ProductDaoImp();
			prodInDao = new ProductInDaoImp();
			Product prod_list=productDao.getOneProduct(productBean.getProd_id());
			ProductIn prodIn_list=prodInDao.getOneProductInByProd_id(productBean.getProd_id(), productInBean.getId());
			product.setId(prod_list.getId());
			product.setProd_id(productBean.getProd_id());
			product.setProd_name(productBean.getProd_name());
			product.setCategory(productBean.getCategory());
			if(this.getPhotoFile()!=null){
				FileInputStream fis=new FileInputStream(this.getPhotoFile());	
				byte[] buffer=new byte[fis.available()];	
				fis.read(buffer);					
				product.setProd_img(buffer);
			}else {
				product.setProd_img(prod_list.getProd_img());
			}
			
			if(prodIn_list.getStatus().equals(productInBean.getStatus())){
				if(productInBean.getStatus().equals("Arrived")) {
					product.setIn_stock(prod_list.getIn_stock());
					product.setPending_stock(prod_list.getPending_stock());
					productIn.setQuantity(prodIn_list.getQuantity());
				}else {
					product.setIn_stock(prod_list.getIn_stock());
					product.setPending_stock(prod_list.getPending_stock()-prodIn_list.getQuantity()+productInBean.getQuantity());
					productIn.setQuantity(productInBean.getQuantity());
				}
			}else {
				if(prodIn_list.getStatus().equals("Arrived") && productInBean.getStatus().equals("On shipping")) {
					product.setIn_stock(prod_list.getIn_stock()-prodIn_list.getQuantity());
					product.setPending_stock(prod_list.getPending_stock()+prodIn_list.getQuantity());
					productIn.setQuantity(prodIn_list.getQuantity());
				}else {
					product.setIn_stock(prod_list.getIn_stock()+productInBean.getQuantity());
					product.setPending_stock(prod_list.getPending_stock()-productInBean.getQuantity());
					productIn.setQuantity(productInBean.getQuantity());
				}
			}
			
			product.setDescription(productBean.getDescription());
			
			productIn.setId(productInBean.getId());
			productIn.setProd_id(productBean.getProd_id());
			productIn.setSupplier(productInBean.getSupplier());
			
			productIn.setBuying_price(productInBean.getBuying_price());
			productIn.setStatus(productInBean.getStatus());
			productIn.setDate(new Date(System.currentTimeMillis()));			
			
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
			return getAllProductIn();
		}
		else{
			return "error";
		}
		
	}
	
	public String getAllProductIn() {
		ProductInDao productInDao=new ProductInDaoImp();
		List prodIn_list=productInDao.getAll();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodIn_list", prodIn_list);		
		return "success";
	}
	
	public void updateStockInfo() {
		
	}
	
	public String update() throws Exception{
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();

        Product product = new Product();
        
		try{
			productDao=new ProductDaoImp();
			Product prod_list=productDao.getOneProduct(productBean.getProd_id());
			product.setId(prod_list.getId());
			product.setProd_id(productBean.getProd_id());
			product.setProd_name(productBean.getProd_name());
			product.setCategory(productBean.getCategory());
			if(this.getPhotoFile()!=null){
				FileInputStream fis=new FileInputStream(this.getPhotoFile());	
				byte[] buffer=new byte[fis.available()];	
				fis.read(buffer);					
				product.setProd_img(buffer);
			}else {
				product.setProd_img(prod_list.getProd_img());
			}

			product.setIn_stock(prod_list.getIn_stock());
			product.setPending_stock(productBean.getPending_stock());
			product.setDescription(productBean.getDescription());
			
			Hsession.update(product);					
			ts.commit();
			Hsession.clear();
			Hsession.close();
			return getAllProduct();
		}catch(Exception e){
			e.printStackTrace();
			return "error";				
		}
		
	}
	
	public String getAllProduct() {
		ProductDao productDao=new ProductDaoImp();
		List prod_list=productDao.getAll();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prod_list", prod_list);		
		return "success";
	}
	
	public String updateOut() throws Exception{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
        ProductOut productOut = new ProductOut();
        Product product = new Product();
        
		try{
			productDao=new ProductDaoImp();
			prodOutDao = new ProductOutDaoImp();
			Product prod_list=productDao.getOneProduct(productBean.getProd_id());
			ProductOut prodOut_list=prodOutDao.getOneProductOut(productOutBean.getId());
			
			product.setId(prod_list.getId());
			product.setProd_id(prod_list.getProd_id());
			product.setProd_name(prod_list.getProd_name());
			product.setCategory(prod_list.getCategory());
			product.setProd_img(prod_list.getProd_img());
			
			product.setIn_stock(prod_list.getIn_stock()+prodOut_list.getQuantity()-productOutBean.getQuantity());
			product.setPending_stock(prod_list.getPending_stock());
			product.setDescription(prod_list.getDescription());
			

			productOut.setId(productOutBean.getId());
			productOut.setProd_id(productBean.getProd_id());
			productOut.setBuyer(productOutBean.getBuyer());
			productOut.setQuantity(productOutBean.getQuantity());
			productOut.setSelling_price(productOutBean.getSelling_price());
			productOut.setStatus(productOutBean.getStatus());
			productOut.setDate(new Date(System.currentTimeMillis()));
			
			if((prod_list.getIn_stock()+prodOut_list.getQuantity()-productOutBean.getQuantity())<0){
				return "error";
			}
			
			Hsession.update(productOut);	
			Hsession.update(product);
			ts.commit();
			
			Hsession.clear();
			Hsession.close();
			return getAllProductOut();
		}catch(Exception e){
			e.printStackTrace();
			return "error";				
		}
		
		
	}
	
	public String getAllProductOut() {
		ProductOutDao productOutDao=new ProductOutDaoImp();
		List prodOut_list=productOutDao.getAll();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodOut_list", prodOut_list);		
		return "success";
	}
	
	public String returnProductOut() {
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
        ProductOut productOut = new ProductOut();
        Product product = new Product();
        
		try{
			productDao=new ProductDaoImp();
			prodOutDao = new ProductOutDaoImp();
			
			Product prod_list=productDao.getOneProduct(productBean.getProd_id());
			ProductOut prodOut_list=prodOutDao.getOneProductOut(productOutBean.getId());
			
			product.setId(prod_list.getId());
			product.setProd_id(prod_list.getProd_id());
			product.setProd_name(prod_list.getProd_name());
			product.setCategory(prod_list.getCategory());
			product.setProd_img(prod_list.getProd_img());
			
			
			product.setIn_stock(prod_list.getIn_stock()+prodOut_list.getQuantity());
			product.setPending_stock(prod_list.getPending_stock());
			product.setDescription(prod_list.getDescription());
			
			productOut.setId(productOutBean.getId());
			productOut.setProd_id(productBean.getProd_id());
			productOut.setBuyer(prodOut_list.getBuyer());
			productOut.setQuantity(prodOut_list.getQuantity());
			productOut.setSelling_price(prodOut_list.getSelling_price());
			productOut.setStatus(prodOut_list.getStatus());
			productOut.setDate(new Date(System.currentTimeMillis()));
			
			Hsession.delete(productOut);
				
			Hsession.update(product);
			ts.commit();
			
			Hsession.clear();
			Hsession.close();

			valid = true;
		}catch(Exception e){
			e.printStackTrace();
							
		}
		if(valid){
			return getAllProductOut();
		}
		else{
			return "error";
		}
	}
	
}
