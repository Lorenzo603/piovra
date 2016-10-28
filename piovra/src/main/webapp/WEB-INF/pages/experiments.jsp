<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
experiemtns!

<c:url var="logoutUrl" value="/logout"/>
<form:form id="logoutForm" method="POST" action="${logoutUrl}">
    <button class="btn btn-lg btn-default" type="submit">Logout</button>
</form:form>

