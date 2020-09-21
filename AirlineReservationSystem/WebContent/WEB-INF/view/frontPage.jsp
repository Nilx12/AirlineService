<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user != null}">
	<h4>Witaj ${user.getFirstName()}</h4>
</c:if>
<c:if test="${user == null}">
	<h4>zaloguj sie</h4>
</c:if>
<a href="searchFlight">szukaj lotów</a>
