<%@tag description="Generic Page Template" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/resources" var="siteResourceUrl"/>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Piovra</title>

        <link rel="stylesheet" href="${siteResourceUrl}/css/lib/bootstrap.min.css" />
        <link rel="stylesheet" href="${siteResourceUrl}/css/lib/datatables.min.css" />
        <link rel="stylesheet" href="${siteResourceUrl}/css/main.css" />
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/jquery-1.12.3.min.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/mustache.min.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/js.cookie.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/lib/datatables.min.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/experimentGridWidget.js"></script>
        <script type="text/javascript" src="${siteResourceUrl}/js/experimentResultWidget.js"></script>
    </head>

    <body>
        <c:url var="homepageUrl" value="/"/>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4">
                        <div class="navbar-left brand">
                            <a class="" href="${homepageUrl}"><img src="${siteResourceUrl}/img/piovra-logo.png"/></a>
                            Piovra
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="navbar-right login-register-class">
                            <sec:authorize access="hasRole('ROLE_USER')" var="isLogged"/>
                            <c:choose>
                                <c:when test="${isLogged}">
                                    <c:url var="logoutUrl" value="/logout"/>
                                    <form:form id="logoutForm" method="POST" action="${logoutUrl}" class="navbar-form">
                                        <button class="btn btn-lg btn-default" type="submit">Logout</button>
                                    </form:form>
                                </c:when>
                                <c:otherwise>
                                    <c:url var="loginUrl" value="/login"/>
                                    <a class="btn btn-lg btn-default" href="${loginUrl}">Login</a>
                                    <c:url var="registerUrl" value="/register"/>
                                    <a class="btn btn-lg btn-default purple" href="${registerUrl}">Register</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <common:breadcrumbs />

        <div class="container-fluid">
            <jsp:doBody/>
        </div>

        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="by"><span>By Lorenzo603</span></div>
                    </div>
                </div>
            </div>
        </footer>

    </body>

</html>