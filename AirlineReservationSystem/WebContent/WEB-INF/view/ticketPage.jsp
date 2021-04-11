<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">

	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
	<c:choose>
		<c:when test="${user != null}">
			<c:set var = "name" value ="${user.getPasazer().getFirstName()}" />
			<c:set var = "surname" value ="${user.getPasazer().getLastName()}" />
			<c:set var = "email" value ="${user.getEmail()}" />
		</c:when>
		<c:otherwise>
			<c:set var = "name" value ="" />
			<c:set var = "surname" value ="" />
			<c:set var = "email" value ="" />
		</c:otherwise>
	</c:choose>
	<div>Airline :${flight.airline.getName()}</div>
	<div>from :${flight.originAirport.getName()}</div>
	<div>to: ${flight.desitinyAirport.getName()}</div>
	<div>first Pilot: ${flight.crew.getFirstPilot().getFirstName()} ${flight.crew.getFirstPilot().getLastName()}</div>
	<div>second Pilot: ${flight.crew.getSecondPilot().getFirstName()} ${flight.crew.getSecondPilot().getLastName()}</div>
	<div>second Pilot: ${flight.crew.getFlightAttendant().getFirstName()} ${flight.crew.getFlightAttendant().getLastName()}</div>
	<br>
	<div>
	<form:form action="ticketShop"  modelAttribute="ticketPropjyerty" method="post">
		<form:select path="flighClass">
				<form:options items = "${flightClasses}" itemLabel="name" itemValue="id" ></form:options>
		</form:select>
		<form:select path="discountId">
				<form:options items = "${discounts}" itemLabel="type" itemValue="id" ></form:options>
		</form:select>
		name: <form:input path="name" value="${name}"/>
		<form:errors path="name" cssClass="error"/><br/> 
		surname:  <form:input path="surname"  value="${surname}"/>
		<form:errors path="surname" cssClass="error"/><br/>
		surname:  <form:input path="email"  value="${email}"/>
		<form:errors path="email" cssClass="error"/><br/>
		
		
		<form:select path="seatId">
			<form:options items = "${avaiableSeats}" itemLabel="name" itemValue="id" ></form:options>
		</form:select>
		
		
	</form:form>
	</div>
	<a href="${pageContext.request.contextPath}/searchFlight">Back to front</a>
</body>