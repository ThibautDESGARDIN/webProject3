
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"><title>Insert title here</title>
</head>

<body>
<div class= container>
	<table class="table table-stripped table-dark table-hover table-bordered">
		<thead class="thead-light">
			<tr>
				<th scope="col">#</th>
				<th scope="col">FirstName</th>
				<th scope="col">LastName</th>
				<th scope="col">StartDate</th>
				<th scope="col"></th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="e">

			<tr>
				<th scope="row">${e.getEmpId()}</th>
				<td>${e.getFirstName()}</td>
				<td>${e.getLastName()}</td>
				<td>${e.getStartDate()}</td>
				<td>
					<form action="del?id=1">
						<input type="submit" value="Supprimer">
					</form>
				</td>
				<td>
					<form action="employeeUpdate.jsp">
						<input type="hidden" name="id" value=1>
						<input type="submit" value="Editer">
					</form>
				</td>
			</tr>

		</c:forEach>
	</table>
	</div>
</body>
</html>