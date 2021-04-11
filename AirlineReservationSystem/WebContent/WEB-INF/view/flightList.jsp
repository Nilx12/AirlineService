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
	<h4>Witaj ${user.getLogin()}</h4>
</c:if>
<c:if test="${user == null}">
	<h4>zaloguj sie</h4>
</c:if>
	<div id="container">
	<table>
		<c:forEach var="flight" items="${flights}">
			<c:url var="kup" value="/buyTicket" >
				<c:param name="fligthId" value="${flight.id}" />
			</c:url>
			<tr class="tableRow">
				<td>${flight.originAirport.getName()}</td>
				<td>${flight.desitinyAirport.getName()}</td>
				<td>${flight.plane.getModel().getManufacturer().getName()} ${flight.plane.getModel().getModel()}</td>
				<td><a href="buyTicket/${fligthId}">Go to shop</a> </td>
			</tr>
		</c:forEach> 
		</table>
		<a href="${pageContext.request.contextPath}/searchFlight">Back to search</a>
	</div>
	</body>