package org.action;

import java.io.File;
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
	private Product product;

	public Product getProduct(Product product) {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
//	public String execute()throws Exception{
//		ProductDao courseDao=new ProductDaoImp();
//		List prod_list=courseDao.getAll();			
//		Map request=(Map)ActionContext.getContext().get("request");
//		request.put("prod_list", prod_list);			
//		return SUCCESS;
//	}
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
	
	public String addProduct() throws Exception{
		boolean valid = false;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session Hsession=sessionFactory.openSession();		
		Transaction ts = Hsession.beginTransaction();
		productDao = new ProductDaoImp();
		Product prod = new Product();
		try{
			//prod.setProd_id(product.getProd_id());
			prod.setProd_name(product.getProd_name());
			prod.setCategory(product.getCategory());
			//prod.setCategory("Furniture");
			//prod.setImage("text");
			prod.setStock(product.getStock());
			prod.setDescription(product.getDescription());
			
			Hsession.save(prod);
			ts.commit();
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
		
		
		
	}
//	public String updateStudent() throws Exception{
//		studentDao=new StudentDaoImp();
//		MajorDao majorDao=new MajorDaoImp();
//		Student stu=new Student();					
//		stu.setSid(student.getSid());					
//		stu.setName(student.getName());					
//		stu.setGender(student.getGender());					
//		stu.setBirthday(student.getBirthday());				
//		stu.setCredit(student.getCredit());					
//		stu.setRemarks(student.getRemarks());					
//	
//		if(this.getPhotoFile()!=null){
//			FileInputStream fis=new FileInputStream(this.getPhotoFile());	
//			byte[] buffer=new byte[fis.available()];	
//			fis.read(buffer);					
//			stu.setPhoto(buffer);
//		}
//		Major mj=majorDao.getOneMajor(major.getMid());
//		
//		stu.setMajor(mj);
//		
//		Set list=studentDao.getOneStudent(student.getSid()).getCourse_set();
//		stu.setCourse_set(list);						
//		studentDao.update(stu);				
//		return SUCCESS;
//	}
}
