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
	private ProductOut prodOut;
	
	public ProductOut getProdOut() {
		return prodOut;
	}
	public void setProdOut(ProductOut prodOut) {
		this.prodOut = prodOut;
	}
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
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		
		SessionFactory sessionFactory2 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession2=sessionFactory2.openSession();		
		Transaction ts2 = Hsession2.beginTransaction();
		
		ProductDao productDaoForId = new ProductDaoImp();
		Product prodById = productDaoForId.getOneProduct(prodOut.getProd_id());
		
		ProductOutDao productOutDaoForId = new ProductOutDaoImp();
		ProductOut prodOutByOut = productOutDaoForId.getOneProductOutByProd_id(prodOut.getProd_id(), prodOut.getId());
		
        ProductOut productOut = (ProductOut) Hsession.load(ProductOut.class, prodOut.getId());
//        Product product = (Product) Hsession2.load(Product.class, prodById.getId());
		
        if((productOut.getStatus()).equals("On shipping")) {
			try{
				productOutDao=new ProductOutDaoImp();

				productOut.setStatus("Delivered");
				
				Hsession.update(productOut);					
				ts2.commit();

				return getAllProduct();
			}catch(Exception e){
				e.printStackTrace();
				return ERROR;				
			}
		
        }else {
        	return getAllProduct();
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
