<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body style="padding-top:50px;"> 
		<c:out value="Current Time: ${calend.time}"/>
		<Form name = "companyDataForm">
		<fieldset align = "center">
		<legend><h3>Company Data</h3></legend>
		<table align="center">
		<tr align="left"><td><Strong>Company Name:</Strong> </td>
							 <td><input type = "text" name = "companyName" size="30" value = "${companyName}"></td></tr>
		<tr align="left"><td><Strong>Company CEO:</Strong></td>
							 <td> <input type = "text" name = "companyName" size="30" value = "${companyCEO}"></td></tr>
		<tr align="left"><td><Strong>Company Current Account (max.10 ch.):</Strong></td>
						 	<td><input type = "text" name = "companyName" size="30" value = "${companyCurAcc}"  maxlength = "10"></td></tr>
		<tr align="left"><td><Strong>Company EDRPOU (max.10 ch.):</Strong></td>
						 	<td><input type = "text" name = "companyName" size="30" value = "${companyEDRPOU}" maxlength = "10"></td></tr>
		<tr align="left"><td><Strong>Company Registered Office:</Strong></td> 
							<td><textarea name = "companyName" cols="24" rows="3">${companyRegOffice}</textarea></td></tr>
		</table>
		</fieldset>
		
    	<p align="center">	<INPUT type="submit" value="Save" style="width:150px; height:45px">
    						<INPUT type="reset" value="Cancel Editing" style="width:150px; height:45px"></p>
    	</Form>
    	<Form action="index.jsp" >
    			<p align="center"> <INPUT type="submit" value="Back to Home page" style="height:45px" align="center"></p> 
		</Form>
		 
 
</body></html> 
