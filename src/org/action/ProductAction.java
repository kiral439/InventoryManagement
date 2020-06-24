package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.impl.*;
import org.dao1.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.*;
import com.opensymphony.xwork2.*;

public class ProductAction extends ActionSupport{
	
	ProductDao productDao;
	private File photoFile;
	private Product productBean;	
	private Product productOutBean;	
	
	private Product productInBean;
	
	public File getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}
	
	public Product getProductOutBean() {
		return productOutBean;
	}
	public void setProductOutBean(Product productOutBean) {
		this.productOutBean = productOutBean;
	}
	public Product getProductBean() {
		return productBean;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}
	
	
	public Product getProductInBean() {
		return productInBean;
	}
	public void setProductInBean(Product productInBean) {
		this.productInBean = productInBean;
	}
	public String execute()throws Exception{
		ProductDao productDao2=new ProductDaoImp();
		List prod_list=productDao2.getAll();			
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prod_list", prod_list);			
		return SUCCESS;
	}
	
	public String getAllProduct() throws Exception{
		ProductDao productDao2=new ProductDaoImp();
		List prod_list=productDao2.getAll();
		if(prod_list!=null){
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("prod_list", prod_list);
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public String getAllProductSession() {
		Map session=(Map)ActionContext.getContext().getSession();
		ProductDao productDao2=new ProductDaoImp();
		List products=productDao2.getAllForHomePage();
		session.put("products", products);
		return SUCCESS;
	}
	
	public String getImage() throws Exception{
		productDao=new ProductDaoImp();
		if(productBean.getId()!=null) {
			byte[] photo=productDao.getOneProduct(productBean.getId()).getProd_img();	
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("image/jpeg");
			ServletOutputStream os=response.getOutputStream();			
			if(photo!=null&&photo.length>0){
				for(int i=0;i<photo.length;i++){
					os.write(photo[i]);
				}
			}
		}
		
		return NONE;									
	}
	
	public String checkQuantity() throws Exception {
		ProductDao productDao=new ProductDaoImp();
		ProductDao productDao2=new ProductDaoImp();
		List prod_list=productDao2.getAll();
		Product prod = productDao.getOneProduct(productOutBean.getProd_id());
		if(prod != null) {
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("prod_list", prod_list);	
			request.put("currentProd", prod);
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public String checkProdId() throws Exception {
		ProductDao productDao=new ProductDaoImp();
		ProductDao productDao2=new ProductDaoImp();
		List prod_list=productDao2.getAll();
		Product prod = productDao.getOneProduct(productInBean.getProd_id());
		Map request=(Map)ActionContext.getContext().get("request");
		if(prod != null) {
			request.put("prod_list", prod_list);	
			request.put("currentProd", prod);
			
			CategoryDao categoryDao=new CategoryDaoImp();				
			List categories=categoryDao.getAll();
			request.put("categories", categories);
			return SUCCESS;
		}
		else {
			Product prod2 = new Product();
			prod2.setProd_id(productInBean.getProd_id());
			request.put("originalProdId", prod2);
			CategoryDao categoryDao=new CategoryDaoImp();				
			List categories=categoryDao.getAll();
			request.put("categories", categories);
			return SUCCESS;
		}
	}
	
}
