<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page>

    <div class="row">
        <div class="col-md-12">
            <div class="breadcrumbs">
                <c:url value="/my-account/experiments" var="experimentsUrl"/>
                <a href="${experimentsUrl}">
                    <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                    Back to experiments list
                </a>
            </div>
        </div>
    </div>

    <c:url value="/my-account/experiment/${experiment.name}" var="experimentContextPath"/>

    <div class="row">
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-4">
                    <button id="expand-all-button" class="btn btn-xs btn-primary">Expand all</button>
                    <button id="collapse-all-button" class="btn btn-xs btn-warning">Collapse all</button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-12">
                            <ul id="factor-list" class="list-group">
                                <c:forEach var="factor" items="${experiment.factors}" varStatus="factorLoopStatus">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <li id="li-factor-${factorLoopStatus.index}" class="list-group-item">
                                                <div class="row factor-item-header">
                                                    <div class="col-md-12">
                                                        <div class="col-md-11">
                                                        <a class="accordion-toggle collapsed" href="#factor-levels-${factorLoopStatus.index}" data-toggle="collapse" aria-expanded="false" aria-controls="factor-levels-${factorLoopStatus.index}">
                                                        </a>
                                                        <div class="factor-item">
                                                            <span class="factor-item-name">${factor.name}</span>
                                                            <form:form id="editFactorForm-${factor.id}" method="POST" action="${experimentContextPath}/edit-factor" modelAttribute="editFactorForm-${factor.id}" class="form-group">
                                                                <form:hidden path="id" />
                                                                <div class="input-group input-group-sm hidden">
                                                                    <form:input path="newName" type="text" value="${factor.name}" class="form-control"/>
                                                                    <span class="input-group-btn">
                                                                        <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button>
                                                                    </span>
                                                                    <span class="input-group-btn cancel-action">
                                                                        <button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                                                    </span>
                                                                </div>
                                                            </form:form>
                                                        </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="factor-item-actions">
                                                                <form:form id="removeFactorForm-${factor.id}" method="POST" action="${experimentContextPath}/remove-factor" modelAttribute="removeFactorForm-${factor.id}">
                                                                    <form:hidden path="id" />
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
                                                                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                                                            <span class="caret"></span>
                                                                        </button>
                                                                        <ul class="dropdown-menu">
                                                                            <li>
                                                                                <a id="removeFactorForm-${factor.id}-submit" href="#">
                                                                                    <span class="glyphicon glyphicon-remove remove-icon" aria-hidden="true"></span>
                                                                                    Remove Factor
                                                                                </a>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </form:form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row factor-item-levels collapse" id="factor-levels-${factorLoopStatus.index}">
                                                    <div class="col-md-12">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <ul class="list-group">
                                                                    <c:forEach var="level" items="${factor.levels}" varStatus="levelLoopStatus">
                                                                        <li id="li-level-${levelLoopStatus.index}" class="list-group-item">
                                                                            <div class="level-item">
                                                                                <div class="col-md-11">
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
                                                                                </div>
                                                                                <div class="col-md-1">
                                                                                    <div class="level-item-actions">
                                                                                        <form:form id="removeLevelForm-${level.id}" method="POST" action="${experimentContextPath}/remove-level" modelAttribute="removeLevelForm-${level.id}">
                                                                                            <form:hidden path="factorId" />
                                                                                            <form:hidden path="id" />
                                                                                            <div class="btn-group">
                                                                                                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
                                                                                                    <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                                                                                    <span class="caret"></span>
                                                                                                </button>
                                                                                                <ul class="dropdown-menu">
                                                                                                    <li>
                                                                                                        <a id="removeLevelForm-${level.id}-submit" href="#">
                                                                                                            <span class="glyphicon glyphicon-remove remove-icon" aria-hidden="true"></span>
                                                                                                            Remove Level
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                        </form:form>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </li>
                                                                    </c:forEach>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="add-level-row col-md-12">
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
                                                    </div>
                                                </div>

                                            </li>
                                        </div>
                                    </div>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
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
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
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