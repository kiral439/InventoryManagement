package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.dao.impl.CategoryDaoImp;
import org.dao.impl.ProductDaoImp;
import org.dao.impl.ProductInDaoImp;
import org.dao1.CategoryDao;
import org.dao1.ProductDao;
import org.dao1.ProductInDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.model.Product;
import org.model.ProductIn;

import com.opensymphony.xwork2.ActionContext;

public class ProductEditAction {
	private ProductDao productDao;
	private ProductDao productDao2;
	private ProductInDao prodInDao;
	private ProductIn prodIn;
	
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
		System.out.println("AAAAAAAAAAAAAAAAA"+prod_list.getIn_stock());
		
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
	
	public String updateIn() throws Exception{
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
		SessionFactory sessionFactory2 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession2=sessionFactory2.openSession();		
		Transaction ts2 = Hsession2.beginTransaction();
		
        ProductIn productIn = new ProductIn();
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
			
			
			System.out.println("Buying price: "+ productInBean.getBuying_price());
			product.setIn_stock(prod_list.getIn_stock());
			product.setPending_stock(productInBean.getQuantity());
			product.setDescription(productBean.getDescription());
			
			productIn.setId(productInBean.getId());
			productIn.setProd_id(productBean.getProd_id());
			productIn.setSupplier(productInBean.getSupplier());
			productIn.setQuantity(productInBean.getQuantity());
			productIn.setBuying_price(productInBean.getBuying_price());
			productIn.setStatus(productInBean.getStatus());
			productIn.setDate(new Date(System.currentTimeMillis()));
			
//			if((productInBean.getStatus()).equals("Arrived")) {
//				updateStockInfo();
//			}
			
			System.out.println("prod_id: "+ productBean.getProd_id());
			System.out.println("prod_name: "+ productBean.getProd_name());
			System.out.println("Category: "+ productBean.getCategory());
			System.out.println("Photo: "+ product.getProd_img());
			System.out.println("In stock: "+ prod_list.getIn_stock());
			System.out.println("Pending stock: "+ productInBean.getQuantity());
			
			System.out.println("DESC: "+ productBean.getDescription());
			
			Hsession2.update(product);					
			ts2.commit();
			
			Hsession.update(productIn);					
			ts.commit();
			
			//prodInDao.update(prod);
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
			
			System.out.println("prod_id: "+ productBean.getProd_id());
			System.out.println("prod_name: "+ productBean.getProd_name());
			System.out.println("Category: "+ productBean.getCategory());
			System.out.println("Photo: "+ product.getProd_img());
			System.out.println("In stock: "+ prod_list.getIn_stock());
			System.out.println("Pending stock: "+ productBean.getPending_stock());
			
			System.out.println("DESC: "+ productBean.getDescription());
			
			Hsession.update(product);					
			ts.commit();
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
	
}
