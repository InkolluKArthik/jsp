<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<title>My first page</title>
	
	</head>
	<body>
	
		<h1>Welcome Content</h1>
		<a href="/logout">Logout</a>
		
		
		<h1>Adding new movies</h1>
		<form action="addmovie" method="get" >
			<label>MovieId
				<input type="number" name="mid" required="required" />
			</label>
			<label>Name
				<input type="text" name="mname" required="required" />
			</label><label>producer
				<input type="text" name="producer" required="required" />
			</label><label>length
				<input type="text" name="length" required="required" />
			</label><label>Director
				<input type="number" name="director" required="required" />
			</label>
			<button type="submit" >Add Movie</button>
		</form>
		
		<table border=1>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Delete</th>
				</tr>
				
			</thead>
			<tbody>
				<c:forEach items="${mess}" var="temp">
			<tr> 
			
				<td>${temp.getId}</td>
				
				
				<td>${temp.getName}</td>
				<td>
					<a href="delete?id=${ temp.getId()}">Delete</a>
				</td>
				
			</tr>
		</c:forEach>
			</tbody>
		</table>
	</body>
</html>