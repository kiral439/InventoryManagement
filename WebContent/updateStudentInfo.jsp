<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Course Management System</title>
</head>
<body bgcolor="#D9DFAA">
	<s:set var="student" value="#request.student"></s:set>
	<!--上传文件时要加入黑体部分-->
	<s:form action="updateStudent" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Student ID:</td>
			<td>
				<input type="text" name="student.sid" value="<s:property value="#student.sid"/>" readOnly/>
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="student.name" value="<s:property value="#student.name"/>" />
			</td>
		</tr>
		<tr>
			<s:radio list="#{1:'male',0:'female'}" value="#student.gender" label="Gender" name="student.gender"></s:radio>
		</tr>
		<tr>
			<td>Major:</td>
			<td>
				<select name="major.mid">
					<s:iterator id="major" value="#request.majors">
						<option value="<s:property value="#major.mid"/>">
							<s:property value="#major.name"/>
						</option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td>Birthday:</td>
			<td>
				<input type="text" name="student.birthday" value="<s:property value="#student.birthday"/>"/>
			</td>
		</tr>
		<tr>
			<td>Remarks:</td>
			<td>
				<input type="text" name="student.remarks" value="<s:property value="#student.remarks"/>" />
			</td>
		</tr>
		<tr>
			<td>Total Credit:</td>
			<td>
				<input type="text" name="student.credit" value="<s:property value="#student.credit"/>" />
			</td>
		</tr>
		<tr>
			<td>Photo:</td>
			<td>
				<input type="file" name="photoFile"/>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Edit"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>