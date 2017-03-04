<%@ page import="ro.sci.classes.AgeCalculator"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.io.IOException" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	Your age is : 
 		<%
  		 AgeCalculator ageCalc = new AgeCalculator();
   
   		 Date todayDate = java.sql.Date.valueOf(LocalDate.now());
		 Date birthDate = java.sql.Date.valueOf(LocalDate.of(1999, 12, 22));
 
  		 out.print(ageCalc.daysBetweenDates(birthDate, todayDate));
		 %>
		
</body>
</html>
