<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page>

    <div class="content">
        <div class="container">
            <c:choose>
                <c:when test="${not empty experiments}">
                    <div class"row">
                        <div class="col-md-12">
                            <h2>Your experiments:</h2>
                            <ul class="list-group experiments-list">
                                <c:forEach var="experiment" items="${experiments}" varStatus="levelLoopStatus">
                                    <li class="list-group-item">
                                        <div class="row">
                                            <div class="experiment col-md-12">
                                                <div class="col-md-9">
                                                    <a href="experiment/${experiment.name}">${experiment.name}</a>
                                                </div>
                                                <div class="col-md-3">
                                                    <c:if test="${not empty experiment.timeCreated}">
                                                        <span class="small-font">Date created: ${experiment.timeCreated}</span>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <div class="experiment col-md-12">
                            <p>You currently have no experiments. Create one!</p>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="row">
                <div class="form-inline col-md-12">
                    <c:url var="createExperimentUrl" value="create-experiment"/>
                    <form:form id="createExperimentForm" method="POST" action="${createExperimentUrl}" modelAttribute="createExperimentForm">
                        <div class="form-group">
                            <form:errors path="name" class="form-error" />
                            <form:input path="name" type="text" placeholder="Experiment name"/>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-default add-button" type="submit">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>
                                Create new experiment
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

    </div>

</template:page>