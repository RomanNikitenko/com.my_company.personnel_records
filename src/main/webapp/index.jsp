<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page errorPage="errorIndexOutOfBoundsException.jsp" /> 
<html>
<style>
td {
	vertical-align: baseline;
}
</style>
<body style="padding-top: 25px;">
	<h1 align="center">Welcome!</h1>
	<jsp:useBean id="gc" class="java.util.GregorianCalendar" />
	<jsp:getProperty name="gc" property="time" />

	<fieldset align="center">
		<legend>
			<h2>Test Mode</h2>
		</legend>

		<table align="center">
			<tr>
				<td>
					<Form action="companyData" method="POST">
						<INPUT type="submit" value="Show/Edit Company Data"
							style="width: 250px; height: 45px">
					</Form>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>
					<Form action="EmplFixSalData" method="POST">
						<INPUT type="submit" value="Generate Employee with fix salary"
							style="width: 250px; height: 45px"> <input type="text"
							value="50" name="quanityEmplFixSal" size="1" maxlength="3">
					</Form>
				</td>
			</tr>
			<tr>
				<td>
					<Form action="EmplHourlyWagesData" method="POST">
						<INPUT type="submit" value="Generate Employee with hourly wages"
							style="width: 250px; height: 45px"> <input type="text"
							value="50" name="quanityEmplHourlyWages" size="1" maxlength="3">
					</Form>
				</td>
			</tr>
		</table>
	</fieldset>
	</body>
</html>
