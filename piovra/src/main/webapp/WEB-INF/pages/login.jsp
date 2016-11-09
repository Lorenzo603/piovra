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
                <c:url var="registerUrl" value="/login/doRegister"/>
                <form:form id="registerForm" method="POST" action="${registerUrl}" modelAttribute="registerForm">
                    <form:errors class="form-error" />

                    <form:errors path="email" class="form-error" />
                    <form:input path="email" />

                    <form:errors path="password" class="form-error" />
                    <form:password path="password" />
                    <form:errors path="confirmPassword" class="form-error" />
                    <form:password path="confirmPassword" />

                    <button class="btn btn-lg btn-default" type="submit">Register</button>
                </form:form>
            </c:otherwise>
        </c:choose>
    </div>

</template:page>