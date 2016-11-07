<%@tag description="Generic Page Template" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Piovra</title>

        <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css" />
        <link rel="stylesheet" href="resources/css/main.css" />
        <script type="text/javascript" src="resources/js/lib/jquery-1.12.3.min.js"></script>
        <script type="text/javascript" src="resources/js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/js/lib/mustache.min.js"></script>
        <script type="text/javascript" src="resources/js/lib/js.cookie.js"></script>
        <script type="text/javascript" src="resources/js/experimentGridWidget.js"></script>
    </head>

    <body>
        <div id="wrapper" class="container-fluid">
            <div class="top">
                <a href="/piovra">
                    <img class="piovra-logo" src="resources/img/piovra-logo.png"/>
                </a>
                <h1>Piovra</h1>
                <br class="clear">

                <sec:authorize access="hasRole('ROLE_USER')" var="isLogged"/>
                <c:choose>
                    <c:when test="${isLogged}">
                        <c:url var="logoutUrl" value="/logout"/>
                        <form:form id="logoutForm" method="POST" action="${logoutUrl}">
                            <button class="btn btn-lg btn-default" type="submit">Logout</button>
                        </form:form>
                    </c:when>
                    <c:otherwise>
                        <form:form id="loginForm" method="POST" action="my-account/doLogin" modelAttribute="loginForm">
                            <form:input path="username" />
                            <form:password path="password" />
                            <button class="btn btn-lg btn-default" type="submit">Login</button>
                        </form:form>
                    </c:otherwise>
                </c:choose>


            </div>

            <jsp:doBody/>

            <div class="footer">Lorenzo603 &copy;2016</div>
            <div id="debug"></div>
        </div>
    </body>

</html>