<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<script type="text/javascript">
    function submitform(actionName){       
        document.userForm.action=actionName ;        
        document.userForm.submit(); 
        alert("submitted");
                           }
</script>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>

<form:form method="POST" commandName="user" name="userForm">
	<table border="1">
		<tr>
			<td>User Name :</td>
			<td><form:input path="name" /></td>
                        <td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td>User ID :</td>
			<td><form:input path="userId" /></td>
                        <td><form:errors path="userId" cssClass="error" /></td>
		</tr>
		
		<tr>
			<td>Country :</td>
			<td><form:select path="country">
				<form:option value="" label="Select" />
				<form:options items="${COUNTRYLIST}" itemValue="value" itemLabel="key" />
			</form:select></td>                        
			<td><form:errors path="country" cssClass="error" /></td>
		</tr>
		
		<tr>                    
                    <td><input type="button" value="Insert" onclick="submitform('userInsertion.do')"></td>
		    <td><input type="button" value="Update" onclick="submitform('userUpdation.do')"></td>
                    <td><input type="button" value="Delete" onclick="submitform('userDeletion.do')"></td>
                    <td><input type="button" value="Search" onclick="submitform('userSearch.do')"></td>
                </tr>
                
                <tr>
                    <td colspan="2">${MESSAGE}</td>
		   
                </tr>
	</table>
</form:form>

</body>
</html>