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
	
	//private HttpServletRequest request;
	
	ProductDao productDao;
	private File photoFile;
	private Product productBean;	
	
	public File getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}

	public Product getProductBean() {
		return productBean;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}
	
	public String execute()throws Exception{
		ProductDao courseDao=new ProductDaoImp();
		List prod_list=courseDao.getAll();			
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prod_list", prod_list);			
		return SUCCESS;
	}
	
	public static String getAllProduct()throws Exception{
		ProductDao courseDao=new ProductDaoImp();
		List prod_list=courseDao.getAll();			
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prod_list", prod_list);			
		return SUCCESS;
	}
	
	public String getImage() throws Exception{
		productDao=new ProductDaoImp();
		byte[] photo=productDao.getOneProduct(productBean.getId()).getProd_img();	
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		ServletOutputStream os=response.getOutputStream();			
		if(photo!=null&&photo.length>0){
			for(int i=0;i<photo.length;i++){
				os.write(photo[i]);
			}
		}
		return NONE;									
	}
	
	/*public String addProduct() throws Exception{
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		productDao = new ProductDaoImp();
		Product product = new Product();
		try{
			product.setProd_id(productBean.getProd_id());
			product.setProd_name(productBean.getProd_name());
			product.setCategory(productBean.getCategory());
			//prod.setCategory("Furniture");
			//prod.setImage("text");
			if(this.getPhotoFile()!=null){
				FileInputStream fis=new FileInputStream(this.getPhotoFile());	
				byte[] buffer=new byte[fis.available()];	
				fis.read(buffer);					
				product.setProd_img(buffer);
			}
			product.setStock(productBean.getStock());
			product.setDescription(productBean.getDescription());
			
//			Hsession.save(prod);
//			ts.commit();
			productDao.save(product);
			valid = true;
		}catch(Exception e){
			e.printStackTrace();		
		}
		if(valid){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
				
	}*/
}
