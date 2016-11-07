<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page>

    <div class="content">

        <c:if test="${not empty experiments}">
            <ul>
                <c:forEach var="experiment" items="${experiments}" varStatus="levelLoopStatus">
                    <li>${experiment.name}</li>
                </c:forEach>
            </ul>
        </c:if>

        <c:url var="createExperimentUrl" value="create-experiment"/>
        <form:form id="createExperimentForm" method="POST" action="${createExperimentUrl}" modelAttribute="createExperimentForm">
            <form:input path="name" type="text" placeholder="Experiment name"/>
            <form:errors path="name" />
            <button class="btn btn-default" type="submit">
                <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>
                Create new experiment
            </button>
        </form:form>


    </div>

</template:page>