package org.action;

import java.io.File;
import java.io.FileInputStream;
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
	private File photoFile;
	private ProductIn prodIn;
	
	public ProductIn getProdIn() {
		return prodIn;
	}
	public void setProdIn(ProductIn prodIn) {
		this.prodIn = prodIn;
	}
	
	public String execute()throws Exception{
		ProductInDao productInDao=new ProductInDaoImp();
		List prodIn_list=productInDao.getAll();	

		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodIn_list", prodIn_list);		
		return SUCCESS;
	}
	
	public String update() throws Exception{
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
        ProductIn productIn = (ProductIn) Hsession.load(ProductIn.class, prodIn.getId());
		
		try{
			productInDao=new ProductInDaoImp();
			
			productIn.setStatus("Arrived");
			
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
