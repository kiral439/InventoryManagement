package org.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.impl.*;
import org.dao1.*;
import org.model.*;
import com.opensymphony.xwork2.*;

public class ProductInAction extends ActionSupport{
	ProductInDao productInDao;
	private File photoFile;
	private ProductIn productIn;
	
	public ProductIn getProductIn() {
		return productIn;
	}
	public void setProductIn(ProductIn productIn) {
		this.productIn = productIn;
	}
	
	public String execute()throws Exception{
		ProductInDao productInDao=new ProductInDaoImp();
		List prodIn_list=productInDao.getAll();	
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prodIn_list", prodIn_list);		
		return SUCCESS;
	}
	
	public String changeStatus() throws Exception{
		productInDao=new ProductInDaoImp();
		ProductIn currProdIn = new ProductIn();
//		currProdIn.setProd_id(productIn.getProd_id());
//		currProdIn.setSupplier(productIn.getSupplier());
//		currProdIn.setQuantity(productIn.getQuantity());
//		currProdIn.setBuying_price(productIn.getBuying_price());
//		currProdIn.setStatus("Arrived");
//		currProdIn.setDate(productIn.getDate());
//		System.out.println(currProdIn.getProd_id());
//		productInDao.update(currProdIn);
		
//		productInDao=new ProductInDaoImp();
//		Integer id = productInDao.getOneProductIn(productIn.getId()).getId();
//		System.out.println(id);
//		HttpServletResponse response=ServletActionContext.getResponse();
//		productInDao.update("Arrived", id);
		
		productInDao=new ProductInDaoImp();
		ProductIn currProd = productInDao.getOneProductIn(productIn.getId());
		productInDao.update("Arrived", productIn.getId());
		
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
