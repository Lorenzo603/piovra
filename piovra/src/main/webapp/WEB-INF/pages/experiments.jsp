<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<template:page>

    <div class="content">

        <ul>
            <c:forEach var="experiment" items="${experiments}" varStatus="levelLoopStatus">
                <li>${experiment.name}</li>
            </c:forEach>
        </ul>

        <form:form id="createExperimentForm" method="POST" action="create-experiment" modelAttribute="createExperimentForm">
            <form:input path="name" type="text" placeholder="Experiment name"/>
            <form:errors path="name" />
            <button class="btn btn-default" type="submit">
                <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>
                Create new experiment
            </button>
        </form:form>


    </div>

</template:page>