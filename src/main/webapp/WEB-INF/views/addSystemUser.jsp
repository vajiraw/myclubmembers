<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
  
  
  <spring:url value="/systemusers/save" var="userActionUrl" />
  
        <h1>Add New User</h1>  
       <form:form method="post" modelAttribute="user" action="${userActionUrl}">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="firstName"  /></td>  
         </tr>    
         <tr>    
          <td>Salary :</td>    
          <td><form:input path="lastName" /></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><form:input path="userName" /></td>  
         </tr>   
         <tr>    
          <td>Password :</td>    
          <td><form:input path="password" /></td>  
         </tr>
         <tr>    
          <td>Contact Number :</td>    
          <td><form:input path="contactNumber" /></td>  
         </tr>
         <tr>    
          <td>Email :</td>    
          <td><form:input path="emailId" /></td>  
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>   