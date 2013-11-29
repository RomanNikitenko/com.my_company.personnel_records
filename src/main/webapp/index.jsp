<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body> 
<h3>Welcome!</h3>
<jsp:useBean id="gc" class="java.util.GregorianCalendar"/> 
<jsp:getProperty name="gc" property="time"/> 
<p>
	<FORM action="companyData"  method="POST">  
    	<INPUT type="submit" value="Show CompanyData"> 
	</FORM>
</p> 
</body>
</html> 
