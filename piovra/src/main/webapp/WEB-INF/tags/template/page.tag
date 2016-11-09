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
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <div class="navbar-brand auto-height">
                        <a href="${homepageUrl}"><img src="${siteResourceUrl}/img/piovra-logo.png"/></a>
                        <span>Piovra</span>
                    </div>
                </div>
                <div class="navbar-right">
                    <sec:authorize access="hasRole('ROLE_USER')" var="isLogged"/>
                    <c:choose>
                        <c:when test="${isLogged}">
                            <c:url var="logoutUrl" value="/logout"/>
                            <form:form id="logoutForm" method="POST" action="${logoutUrl}">
                                <button class="btn btn-lg btn-default" type="submit">Logout</button>
                            </form:form>
                        </c:when>
                        <c:otherwise>
                                <a class="btn btn-lg btn-default purple" href="login">Register</a>
                                <c:url var="doLoginUrl" value="/my-account/doLogin"/>
                                <form:form id="loginForm" method="POST" action="${doLoginUrl}" modelAttribute="loginForm" class="navbar-form">
                                    <div class="form-group">
                                        <form:input path="username" />
                                    </div>
                                    <div class="form-group">
                                        <form:password path="password" />
                                    </div>
                                    <button class="btn btn-lg btn-default purple-empty" type="submit">Login</button>
                                </form:form>

                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <jsp:doBody/>
        </div>

        <footer>
            <div class="container-fluid">
                <div class="by"><span>By Lorenzo603</span></div>
            </div>
        </footer>

    </body>

</html>