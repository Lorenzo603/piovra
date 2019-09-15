<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page>

    <div class="content">
        <sec:authorize access="hasRole('ROLE_USER')" var="isLogged"/>
        <c:choose>
            <c:when test="${isLogged}">
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <c:url var="registerUrl" value="/register/doRegister"/>
                                    <form:form id="registerForm" method="POST" action="${registerUrl}" modelAttribute="registerForm">
                                        <form:errors class="form-error" />
                                        <div class="form-group">
                                            <label for="email">Email address</label>
                                            <form:input path="email" placeholder="Email" class="form-control"/>
                                            <form:errors path="email" class="form-error" />
                                        </div>
                                        <div class="form-group">
                                            <label for="password">Password</label>
                                            <form:password path="password" placeholder="Password" class="form-control"/>
                                            <form:errors path="password" class="form-error" />
                                        </div>
                                        <div class="form-group">
                                            <label for="confirmPassword">Confirm Password</label>
                                            <form:password path="confirmPassword" placeholder="Confirm Password" class="form-control"/>
                                            <form:errors path="confirmPassword" class="form-error" />
                                        </div>
                                        <div class="form-group text-center">
                                            <button class="btn btn-lg btn-default purple" type="submit">Register</button>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</template:page>