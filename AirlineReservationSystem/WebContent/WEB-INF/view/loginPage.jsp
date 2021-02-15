<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
<c:if test="${user != null}">
	<h4>Witaj ${user.getFirstName()}</h4>
</c:if>
<c:if test="${user == null}">
	<h4>zaloguj sie</h4>
</c:if>
	<div id="container">
		<form:form action="processLogin"  modelAttribute="userToLoginr" method="post">
		
			Login: <form:input path="login"/>
			<form:errors path="login" cssClass="error"/><br/>
			Password:  <form:password path="password"/>
			<form:errors path="password" cssClass="error"/><br/>
		 	
			<input type="submit" value="Save" />	
		</form:form>
		
		<a href="${pageContext.request.contextPath}">Back to front</a>
	</div>
	</body>