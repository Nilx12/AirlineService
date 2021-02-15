<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user != null}">
	<h4>Witaj ${user.getLogin()} 	<a href="logout"><button>wyloguj</button></a> </h4>
</c:if>
<c:if test="${user == null}">
	<a href="login"><button>zaloguj sie</button></a>
</c:if>
<br/>
<a href="searchFlight">szukaj lotów</a>
