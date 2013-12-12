
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page errorPage="/error/errorStringDigitIncludeEception.jsp" />

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

<body>
	<table width="100%">
		<tr>
			<td align="left">
				<Form action="index.jsp">
					<INPUT type="submit" value="<= Back to Home page"
						style="height: 45px">
				</Form>
			</td>
			<td align="right">
				<Form action="addEmplFixSalData.jsp">
					<INPUT type="submit" value="Add Employee"
						style="width: 150px; height: 45px">
				</Form>
				<Form action="delEmplFixSal">
					<INPUT type="submit" value="Delete Employee"
						style="width: 150px; height: 45px">
				</Form>
			</td>
		</tr>
	</table>

	<h2 align="center">Employee with Fixsal Salary Data</h2>


	<Form name="emplFixSalData" action="EmplFixSalData" method="POST">
		
		<p align="center">
			<INPUT TYPE="HIDDEN" NAME="HIDDEN" value="saveEmplFixSalData">
			<INPUT type="submit" value="Save" style="width: 150px; height: 45px">
		</p>
		<p align="center"><label>(to save the edited cell press <strong>Enter</strong> or <strong>Save</strong>)</label></p>
		<c:out value="Current Time: ${calend.time}" />
		<table border="1">
			<tr>
				<c:forEach begin="0" end="${fn:length(arrColumnNames)-1}"
					var="index">
					<th>${arrColumnNames[index]}</th>
				</c:forEach>
			</tr>
			<c:forEach var="row" items="${arrObjEmpl}">
				<tr align="center" height="50">
					<td><label
						name="personalNumber${row.personalNumber}"
						style="border: 0; outline: 0; text-align: center">${row.personalNumber}</label></td>
					<td><input type="text"
						name="surnameNameMiddlename${row.personalNumber}"
						value="${row.surnameNameMiddlename}" size="30"
						style="border: 0; outline: 0; text-align: center"></td>
					<td><input type="text" name="department${row.personalNumber}"
						value="${row.department}"
						style="border: 0; outline: 0; text-align: center"></td>
					<td><input type="text" name="post${row.personalNumber}"
						value="${row.post}"
						style="border: 0; outline: 0; text-align: center"></td>
					<td><input type="text"
						name="averageSalary${row.personalNumber}"
						value="${row.averageSalary}"
						style="border: 0; outline: 0; text-align: center"></td>
					<td><input type="text"
						name="monthlyPayment${row.personalNumber}"
						value="${row.monthlyPayment}"
						style="border: 0; outline: 0; text-align: center"></td>
					<td><input type="text"
						name="taxIdentifNum${row.personalNumber}"
						value="${row.taxIdentifNum}"
						style="border: 0; outline: 0; text-align: center"></td>
					<td><input type="text" name="education${row.personalNumber}"
						value="${row.education}"
						style="border: 0; outline: 0; text-align: center"></td>
					<td><textarea name="passport${row.personalNumber}">${row.passport}</textarea></td>
					<td><textarea name="residence${row.personalNumber}">${row.residence}</textarea></td>
				</tr>
			</c:forEach>
		</table>
	</Form>
</body>
</html>
