package org.action;

import java.sql.*;
import java.util.*;
import com.opensymphony.xwork2.*;

public class LogOutAction {
	public String execute() throws Exception {
		
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		session.put("user", null);

		return "success";
	}
}
