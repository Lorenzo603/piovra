<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page>


    <div class="breadcrumbs">
        <c:url value="/my-account/experiments" var="experimentsUrl"/>
        <a href="${experimentsUrl}">
            <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
            Back to experiments list
        </a>
    </div>

    <c:url value="/my-account/experiment/${experiment.name}" var="experimentContextPath"/>

    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <button id="expand-all-button" class="btn btn-xs btn-primary">Expand all</button>
                    <button id="collapse-all-button" class="btn btn-xs btn-warning">Collapse all</button>
                </div>
                <div class="panel-body factor-table">
                    <ul id="factor-list" class="list-group">
                        <c:forEach var="factor" items="${experiment.factors}" varStatus="factorLoopStatus">
                            <li id="li-factor-${factorLoopStatus.index}" class="list-group-item">
                                <div class="factor-item">
                                    <div class="factor-item-header">
                                        <a class="accordion-toggle collapsed" href="#factor-levels-${factorLoopStatus.index}" data-toggle="collapse" aria-expanded="false" aria-controls="factor-levels-${factorLoopStatus.index}">
                                        </a>
                                        <div class="factor-item-title">
                                            <span class="factor-item-name">${factor.name}</span>
                                            <div class="factor-item-actions hidden">
                                                <form:form id="editFactorForm-${factor.id}" method="POST" action="${experimentContextPath}/edit-factor" modelAttribute="editFactorForm-${factor.id}">
                                                    <form:hidden path="id" />
                                                    <button class="btn btn-xs edit-button" type="submit">
                                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                    </button>
                                                </form:form>
                                                <form:form id="removeFactorForm-${factor.id}" method="POST" action="${experimentContextPath}/remove-factor" modelAttribute="removeFactorForm-${factor.id}">
                                                    <form:hidden path="id" />
                                                    <button class="btn btn-xs remove-button" type="submit">
                                                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                    </button>
                                                </form:form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="factor-item-levels collapse" id="factor-levels-${factorLoopStatus.index}">
                                        <ul>
                                            <c:forEach var="level" items="${factor.levels}" varStatus="levelLoopStatus">
                                                <li id="li-level-${levelLoopStatus.index}" class="list-group-item">
                                                    <div class="level-item">
                                                        <span class="level-item-name">${level.name}</span>
                                                        <form:form id="editLevelForm-${level.id}" method="POST" action="${experimentContextPath}/edit-level" modelAttribute="editLevelForm-${level.id}" class="form-group">
                                                            <form:hidden path="factorId" />
                                                            <form:hidden path="id" />
                                                            <div class="input-group input-group-sm hidden">
                                                                <form:input path="newName" type="text" value="${level.name}" class="form-control"/>
                                                                <span class="input-group-btn">
                                                                    <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button>
                                                                </span>
                                                                <span class="input-group-btn cancel-action">
                                                                    <button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                                                </span>
                                                            </div>
                                                        </form:form>
                                                        <div class="level-item-actions hidden">
                                                            <form:form id="removeLevelForm-${level.id}" method="POST" action="${experimentContextPath}/remove-level" modelAttribute="removeLevelForm-${level.id}">
                                                                <form:hidden path="factorId" />
                                                                <form:hidden path="id" />
                                                                <button class="btn btn-xs remove-button" type="submit">
                                                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                                </button>
                                                            </form:form>
                                                        </div>
                                                    </div>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                        <form:form id="addLevelForm-${factor.id}" method="POST" action="${experimentContextPath}/add-level" modelAttribute="addLevelForm-${factor.id}">
                                            <form:hidden path="factorId" />
                                            <form:input path="name" type="text" placeholder="Level name"/>
                                            <form:errors path="name" />
                                            <button class="btn btn-xs add-button" type="submit">
                                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                Add new Level
                                            </button>
                                        </form:form>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <form:form id="addFactorForm" method="POST" action="${experimentContextPath}/add-factor" modelAttribute="addFactorForm">
                        <div class="factor-row add-factor-row">
                            <form:input path="name" type="text" placeholder="Factor name"/>
                            <form:errors path="name" />
                            <button class="btn btn-default add-button" type="submit">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>
                                Add new Factor
                            </button>
                        </div>
                    </form:form>
                </div>

                <div class="panel-footer">
                    <form:form id="calculateForm" method="POST" action="${experimentContextPath}/calculate" modelAttribute="calculateForm">
                        <button class="btn btn-lg btn-default" type="submit">Calculate</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">

        $(document).ready(
            function() {
                ExperimentGridWidget.init();
            }
        );
    </script>
</template:page>