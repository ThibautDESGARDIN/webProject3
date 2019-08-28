<%@page import="fr.formation.inti.entities.Employee"%>
<%@page import="fr.formation.inti.service.EmployeeService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update employee</title>
</head>
<body>


<% 
	String id = request.getParameter("id");
	EmployeeService service = new EmployeeService();
	
	Employee emp = service.findById(Integer.parseInt(id));

%>
		
		<form action="update" method="post">
		<input type="hidden" name="id" value="<%= emp.getEmpId()%>">
		<label>Prénom :</label>
		<br><input type="text" name="firstname" placeholder="Entrez votre prénom" value="<%= emp.getFirstName()%>"><br>
		<br><label>Nom    :</label>
		<br><input type="text" name="lastname" placeholder="Entrez votre nom" value="<%= emp.getLastName()%>"><br>
		<br><label>Date de début :</label>
		<br><input type="date" name="start" value="<%= emp.getStartDate()%>">
		<br><br><input type="submit" value="Update"></form>
			
		
		
</body>
</html>