<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>List customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manger</h2>
	</div>
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';" class="add-button"/>
		
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tmpCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tmpCustomer.id}">
						</c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tmpCustomer.id}">
						</c:param>
					</c:url>
				
					<tr>
						<td>${tmpCustomer.firstName}</td>
						<td>${tmpCustomer.lastName}</td>
						<td>${tmpCustomer.email}</td>
						<td><a href="${updateLink}">Update</a>
						| 
						<a href="${deleteLink}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

</body>

</html>