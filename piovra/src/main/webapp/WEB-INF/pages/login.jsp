<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>

    <div class="content">
        <form:form id="loginForm" method="POST" action="my-account/doLogin" modelAttribute="loginForm">
            <form:input path="username" />
            <form:password path="password" />
            <button class="btn btn-lg btn-default" type="submit">Login</button>
        </form:form>
    </div>

</template:page>