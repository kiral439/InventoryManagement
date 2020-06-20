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

public class ProductAction extends ActionSupport{
	ProductDao productDao;
	private File photoFile;
	private Product product;
	
	public String execute()throws Exception{
		ProductDao courseDao=new ProductDaoImp();
		List prod_list=courseDao.getAll();			
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("prod_list", prod_list);			
		return SUCCESS;
	}
	public String getImage() throws Exception{
		productDao=new ProductDaoImp();
		byte[] photo=productDao.getOneProduct(product.getId()).getProd_img();	
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
	
	
}
