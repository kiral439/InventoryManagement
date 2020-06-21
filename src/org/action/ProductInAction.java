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
		
		SessionFactory sessionFactory2 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession2=sessionFactory2.openSession();		
		Transaction ts2 = Hsession2.beginTransaction();
		
        ProductIn productIn = (ProductIn) Hsession.load(ProductIn.class, prodIn.getId());
        Product product = (Product) Hsession2.load(Product.class, prodIn.getId());
		
		try{
			productInDao=new ProductInDaoImp();
			
			product.setIn_stock(product.getPending_stock());
			product.setPending_stock(0);
			productIn.setStatus("Arrived");
			
			Hsession2.update(product);					
			ts2.commit();
			
			Hsession.update(productIn);					
			ts.commit();
			
			//productInDao.update(prod);
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
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
		SessionFactory sessionFactory2 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession2=sessionFactory2.openSession();		
		Transaction ts2 = Hsession2.beginTransaction();
		
//		productInDao = new ProductInDaoImp();
//		productDao = new ProductDaoImp();
		
		ProductIn productIn = new ProductIn();
		Product prod = new Product();
		
		try{
			productIn.setProd_id(productInBean.getProd_id());
			productIn.setSupplier(productInBean.getSupplier());
			productIn.setQuantity(productInBean.getQuantity());
			productIn.setBuying_price(productInBean.getBuying_price());
			productIn.setStatus(productInBean.getStatus());
			productIn.setDate(new Date(System.currentTimeMillis()));
			
			Hsession.save(productIn);
			ts.commit();
			
			prod.setProd_id(productInBean.getProd_id());
			prod.setProd_name(productBean.getProd_name());
			prod.setCategory(productBean.getCategory());
			//prod.setCategory("Furniture");
			//prod.setImage("text");
			if(this.getPhotoFile()!=null){
				FileInputStream fis=new FileInputStream(this.getPhotoFile());	
				byte[] buffer=new byte[fis.available()];	
				fis.read(buffer);					
				prod.setProd_img(buffer);
			}
			prod.setIn_stock(0);
			prod.setPending_stock(productInBean.getQuantity());
			prod.setDescription(productBean.getDescription());
			
			Hsession2.save(prod);
			ts2.commit();
			
			//productDao.save(prod);
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

//	public String getImage() throws Exception{
//		productInDao=new ProductInDaoImp();
//		ProductIn currProd = productInDao.getOneProductIn(product.getId());
//		byte[] photo=currProd.getProd_img();	
//		HttpServletResponse response=ServletActionContext.getResponse();
//		response.setContentType("image/jpeg");
//		ServletOutputStream os=response.getOutputStream();			
//		if(photo!=null&&photo.length>0){
//			for(int i=0;i<photo.length;i++){
//				os.write(photo[i]);
//			}
//		}
//		return NONE;									
//	}
}
