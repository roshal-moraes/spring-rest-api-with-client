<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-city-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>City & Population - REST</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save City</h3>
	
		<form:form action="saveCity" modelAttribute="city" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>City name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Country name:</label></td>
						<td><form:input path="country" /></td>
					</tr>

					<tr>
						<td><label>Population:</label></td>
						<td><form:input path="population" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/city/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










