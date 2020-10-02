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
		<form:form action="getFlight"  modelAttribute="fligthSearcher" method="post">
		
			Origin Airport: <form:input path="originAirport"/>
			<form:errors path="originAirport" cssClass="error"/><br/>
				Last name:  <form:input path="desitinyAirport"/>
				<form:errors path="desitinyAirport" cssClass="error"/><br/>
				<form:input path="time" maxlength="5"/>
				<form:errors path="time" cssClass="error"/><br/>
		 	
			<input type="submit" value="Save" />	
		</form:form>
		
		<a href="${pageContext.request.contextPath}">Back to front</a>
	</div>
	</body>