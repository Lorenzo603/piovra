<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page>

    <div class="content">
        <div class="container">
            <c:choose>
                <c:when test="${not empty experiments}">
                    <h2>Your experiments:</h2>
                    <ul class="list-group experiments-list">
                        <c:forEach var="experiment" items="${experiments}" varStatus="levelLoopStatus">
                            <li class="list-group-item">
                                <span class="lead">
                                    <a href="experiment/${experiment.name}">${experiment.name}</a>
                                    <c:if test="${not empty experiment.timeCreated}">
                                        <span class="small-font">Date created: ${experiment.timeCreated}</span>
                                    </c:if>
                                </span>
                            </li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:otherwise>
                    You currently have no experiments. Create one!
                </c:otherwise>
            </c:choose>

            <c:url var="createExperimentUrl" value="create-experiment"/>
            <form:form id="createExperimentForm" method="POST" action="${createExperimentUrl}" modelAttribute="createExperimentForm">
                <form:input path="name" type="text" placeholder="Experiment name"/>
                <form:errors path="name" />
                <button class="btn btn-default add-button" type="submit">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>
                    Create new experiment
                </button>
            </form:form>
        </div>

    </div>

</template:page>