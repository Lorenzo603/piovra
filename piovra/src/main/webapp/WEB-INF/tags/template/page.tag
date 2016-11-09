<%@tag description="Generic Page Template" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/resources" var="siteResourceUrl"/>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Piovra</title>

        <link rel="stylesheet" href="${siteResourceUrl}/css/lib/bootstrap.min.css" />
        <link rel="stylesheet" href="${siteResourceUrl}/css/main.css" />
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/jquery-1.12.3.min.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/mustache.min.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/js.cookie.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/experimentGridWidget.js"></script>
    </head>

    <body>
        <c:url var="homepageUrl" value="/"/>
        <header>
            <div class="container-fluid">
                <div id="logo">
                    <a href="${homepageUrl}">
                        <img class="piovra-logo" src="${siteResourceUrl}/img/piovra-logo.png"/>
                        <h1>Piovra</h1>
                    </a>
                </div>
                <sec:authorize access="hasRole('ROLE_USER')" var="isLogged"/>
                <c:choose>
                    <c:when test="${isLogged}">
                        <c:url var="logoutUrl" value="/logout"/>
                        <form:form id="logoutForm" method="POST" action="${logoutUrl}">
                            <button class="btn btn-lg btn-default" type="submit">Logout</button>
                        </form:form>
                    </c:when>
                    <c:otherwise>
                        <div class="top-right">
                            <a class="btn btn-default purple" href="login">Register</a>
                            <c:url var="doLoginUrl" value="/my-account/doLogin"/>
                            <form:form id="loginForm" method="POST" action="${doLoginUrl}" modelAttribute="loginForm">
                                <form:input path="username" />
                                <form:password path="password" />
                                <button class="btn btn-lg btn-default purple-empty" type="submit">Login</button>
                            </form:form>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </header>

        <div class="container-fluid">
            <jsp:doBody/>
        </div>

        <footer>
            <div class="container-fluid">
                <span>Lorenzo603 &copy;2016</span>
                <div id="debug"></div>
            </div>
        </footer>

    </body>

</html>