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
	<div>Airline :${flight.airline.getName()}</div>
	<div>from :${flight.originAirport.getName()}</div>
	<div>to: ${flight.desitinyAirport.getName()}</div>
	<div>first Pilot: ${flight.crew.getFirstPilot().getFirstName()} ${flight.crew.getFirstPilot().getLastName()}</div>
	<div>second Pilot: ${flight.crew.getSecondPilot().getFirstName()} ${flight.crew.getSecondPilot().getLastName()}</div>
	<div>second Pilot: ${flight.crew.getFlightAttendant().getFirstName()} ${flight.crew.getFlightAttendant().getLastName()}</div>
	<br>
	<div>
	<c:forEach var="klass" items="${flightClasses}">
		<ul>
			<li>${klass.name}</li>
		</ul>
	</c:forEach>
	</div>
	<a href="${pageContext.request.contextPath}/searchFlight">Back to front</a>
</body>