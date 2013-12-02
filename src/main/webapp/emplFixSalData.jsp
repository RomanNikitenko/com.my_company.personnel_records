<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body style="padding-top:20px;"> 
	
	<Form action="index.jsp" >
    	<p align="left"> <INPUT type="submit" value="<= Back to Home page" style="height:45px" align="center"></p> 
	</Form>
	
	<h2 align="center">Employee with Fixsal Salary Data</h2>
	<c:out value="Current Time: ${calend.time}"/>
	
	<table align="center" border = 1>
	<tr>
	<c:forEach begin="0" end="${fn:length(arrColumnNames)-1}" var="index">
			<th>${arrColumnNames[index]}</th>		
	</c:forEach>
	</tr>
	<c:forEach var="row" items="${arrObjEmpl}">
		<tr>  
			<td>${row.personalNumber}		</td>
			<td>${row.surnameNameMiddlename}</td>
			<td>${row.department}			</td>
    		<td>${row.post}					</td> 
    		<td>${row.averageSalary}		</td>
    		<td>${row.monthlyPayment}		</td>
			<td>${row.taxIdentifNum}		</td>
			<td>${row.education}			</td>
    		<td>${row.passport}				</td> 
    		<td>${row.residence}			</td>
    	</tr>
	</c:forEach>
</table> 
</body>
</html> 
