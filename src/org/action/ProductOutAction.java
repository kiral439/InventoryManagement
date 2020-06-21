package org.action;

import java.io.File;
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
	private File photoFile;
	private ProductOut productOut;
	
	public ProductOut getProductOut() {
		return productOut;
	}
	public void setProductOut(ProductOut productOut) {
		this.productOut = productOut;
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
	
//	public String getImage() throws Exception{
//		productOutDao=new ProductOutDaoImp();
//		ProductOut currProd = productOutDao.getOneProductOut(product.getId());
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
