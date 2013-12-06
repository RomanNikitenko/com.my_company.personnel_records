<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Employee with Fixsal Salary Data</title>
	<style>
textarea {
	border: 0;
	outline: 0;
	overflow: hidden;
}
</style>
</head>
<html>
	
	<body style="padding-top:20px;"> 
	
	
	<Form action="index.jsp" >
    	<p align="left"> <INPUT type="submit" value="<= Back to Home page" style="height:45px"></p> 
	</Form>
	
	<h2 align="center">Employee with Fixsal Salary Data</h2>
	<c:out value="Current Time: ${calend.time}"/>
	
	<table border="1">
	<tr>
	<c:forEach begin="0" end="${fn:length(arrColumnNames)-1}" var="index">
			<th>${arrColumnNames[index]}</th>		
	</c:forEach>
	</tr>
	<c:forEach var="row" items="${arrObjEmpl}">
		<tr align="center">  
			<td><input type = "text" name = "personalNumber" 		value = "${row.personalNumber}" 
												style = "border: 0;	outline: 0;	text-align:center"></td>
			<td><input type = "text" name = "surnameNameMiddlename" value = "${row.surnameNameMiddlename}"
									 size="30" style = "border: 0;	outline: 0;	text-align:center"></td>
			<td><input type = "text" name = "department"			value = "${row.department}"
												style = "border: 0;	outline: 0;	text-align:center"></td>
    		<td><input type = "text" name = "post"		          	value = "${row.post}"
    											style = "border: 0;	outline: 0;	text-align:center"></td> 
    		<td><input type = "text" name = "averageSalary"         value = "${row.averageSalary}" 
    											style = "border: 0;	outline: 0;	text-align:center"></td>
    		<td><input type = "text" name = "monthlyPayment"		value = "${row.monthlyPayment}"
    											style = "border: 0;	outline: 0;	text-align:center"></td>
			<td><input type = "text" name = "taxIdentifNum"	    	value = "${row.taxIdentifNum}"
												style = "border: 0;	outline: 0;	text-align:center"></td>
			<td><input type = "text" name = "education" 			value = "${row.education}"
											 style = "border: 0;	outline: 0;	text-align:center"></td>
    		<td><textarea 			 name = "passport">${row.passport}</textarea></td> 
    		<td><textarea 			 name = "residence">${row.residence}</textarea></td>
    	</tr>
	</c:forEach>
</table> 
</body>
</html> 
