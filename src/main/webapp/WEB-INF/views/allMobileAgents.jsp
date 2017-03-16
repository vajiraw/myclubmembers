<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Users List</h1>
	<table border="2" width="70%" cellpadding="2">

		<c:if test="${not empty users}">

			<ul>
				<c:forEach var="user" items="${users}">
					<tr>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.userName}" /></td>
						<td><c:out value="${user.contactNumber}" /></td>
						<td><c:out value="${user.emailId}" /></td>
						<%-- <td><a href="getMember/${mems.id}"><c:out value="${mems.id}" /></td> --%>
					</tr>

				</c:forEach>
			</ul>






		</c:if>
</body>
</html>