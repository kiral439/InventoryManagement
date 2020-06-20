<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Course Management System</title>
</head>
<body bgcolor="#D9DFAA">
	<table width="400" border="1">
		<caption>All Course Information</caption>
		<tr>
			<th>Course ID</th><th>Name</th><th>Semester</th><th>Student Num.</th><th>Credit</th><th>Operation</th>
		</tr>
		<s:iterator value="#request.list" var="course">
		<tr>
			<td align="center"><s:property value="#course.cid"/></td>
			<td align="center"><s:property value="#course.name"/></td>
			<td align="center"><s:property value="#course.semester"/></td>
			<td align="center"><s:property value="#course.stu_num"/></td>
			<td align="center"><s:property value="#course.credit"/></td>
			<td align="center">
				<a href="selectCourse.action?course.cid=<s:property value="#course.cid"/>"
					onClick="if(!confirm('Do you want to choose this course？'))
					return false;else return true;">Register</a>
			</td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>