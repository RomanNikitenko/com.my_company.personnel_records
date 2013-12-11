
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page errorPage="/error/errorStringDigitIncludeEception.jsp" />

<title>Add EmplFixSal</title>
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
	<p align="left">
	
	<Form action="index.jsp">
		<INPUT type="submit" value="<= Back to Home page" style="height: 45px">
	</Form>
	</p>

	<h2 align="center"> Add Employee with Fixsal Salary</h2>

	<Form name="addEmplFixSal" action="AddEmplFixSal" method="POST">

		<table border="1" align="center">
			<tr align="center">
				<td><Strong>Personal Number:</Strong></td>
				<td><input type="text" name="personalNumber"
					placeholder="input a value of type 'int'"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Surname, Name, Middle Name:</Strong></td>
				<td><input type="text" name="surnameNameMiddlename"
					placeholder="do not enter the numbers"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Department:</Strong></td>
				<td><input type="text" name="department"
					placeholder="possible numbers and text"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Post:</Strong></td>
				<td><input type="text" name="post"
					placeholder="do not enter the numbers"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Average Salary:</Strong></td>
				<td><input type="text" name="averageSalary"
					placeholder="input only digits"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Monthly Payment:</Strong></td>
				<td><input type="text" name="monthlyPayment"
					placeholder="input only digits"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Tax identification number:</Strong></td>
				<td><input type="text" name="taxIdentifNum"
					placeholder="input only digits"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Education:</Strong></td>
				<td><input type="text" name="education"
					placeholder="do not enter the numbers"
					style="border: 0; outline: 0; text-align: center"></td>
			</tr>
			<tr align="center">
				<td><Strong>Passport:</Strong></td>
				<td><textarea name="passport" placeholder="possible to enter numbers and text"></textarea></td>
			</tr>
			<tr align="center">
				<td><Strong>Residence:</Strong></td>
				<td><textarea name="residence" placeholder="possible to enter numbers and text"></textarea></td>
			</tr>
		</table>
		<p align="center">
			<INPUT type="submit" value="Add" style="width: 150px; height: 45px">
		</p>

	</Form>
</body>
</html>
