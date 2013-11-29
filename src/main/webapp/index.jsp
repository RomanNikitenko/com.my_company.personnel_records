<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body style="padding-top: 25px;">
	<h1 align="center">Welcome!</h1>
	<jsp:useBean id="gc" class="java.util.GregorianCalendar" />
	<jsp:getProperty name="gc" property="time" />

	<fieldset align="center">
		<legend>
			<h3>Test Mode</h3>
		</legend>

		<table align="center">
			<style>
				td {vertical-align: baseline;}
			</style>

			<tr>
				<td>
					<Form action="companyData" method="POST">
						<INPUT type="submit" value="Show/Edit Company Data"
							style="width: 250px; height: 45px">
					</Form>
				</td>
			</tr>
			<tr>
				<td><Form>
						<INPUT type="reset" value="Generate Employee with fix salary"
							style="width: 250px; height: 45px">
					</Form></td>
				<td><input type="text" name="quanityEmplFixSal" size="1"
					maxlength="3"></td>
			</tr>
			<tr>
				<td><Form>
						<INPUT type="reset" value="Generate Employee with hourly wages"
							style="width: 250px; height: 45px">
					</Form></td>
				<td><input type="text" name="quanityEmplHourlyWages" size="1"
					maxlength="3"></td>
			</tr>
		</table>
	</fieldset>
	</body>
</html>
