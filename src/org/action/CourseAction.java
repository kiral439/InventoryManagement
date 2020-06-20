package org.action;
import java.util.*;
import org.dao1.*;
import org.dao.impl.*;
import com.opensymphony.xwork2.*;
public class CourseAction extends ActionSupport{
	public String execute()throws Exception{
		CourseDao courseDao = new CourseDaoImp();
		
		List list=courseDao.getAll();			
		Map request=(Map)ActionContext.getContext().get("request");
		
		request.put("list", list);			
		return SUCCESS;
	}
}
