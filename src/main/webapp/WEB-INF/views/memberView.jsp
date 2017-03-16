<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>
<html>
<spring:url value="/updateMember" var="userActionUrl" />
<body>
 <form:form method="POST" modelAttribute="member" action="${userActionUrl}">    
<form:hidden path="id" />
<table >    
<tr>
<td><img  src="data:image/jpeg;base64,${member.imageName}" /> </td>    
</tr>
<tr>            
<td><form:input path="fullName"/></td>
</tr>
<tr>            
<td><form:input path="address"/></td>
</tr>
<tr>            
<td><form:input path="contactNo"/></td>
</tr>
<tr>            
<td><form:input path="mobileNo"/></td>
</tr>
<tr>    
  <td> </td>    
   <td><input type="submit" value="Save" /></td>    
</tr>    

</table>
</form:form>
</body>
</html>
