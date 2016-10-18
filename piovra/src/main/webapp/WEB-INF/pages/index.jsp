<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Piovra</title>

    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    <script type="text/javascript" src="resources/js/lib/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/mustache.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/js.cookie.js"></script>
    <script type="text/javascript" src="resources/js/experimentGridWidget.js"></script>
</head>
<body>
    <div id="wrapper" class="container-fluid">
        <div class="top">
			<a href="/piovra">
				<img class="piovra-logo" src="resources/img/piovra-logo.png"/>
			</a>
			<h1>Piovra</h1>
			<br class="clear">
		</div>

        <div class="content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <button id="expand-all-button" class="btn btn-xs btn-primary">Expand all</button>
                    <button id="collapse-all-button" class="btn btn-xs btn-warning">Collapse all</button>
                </div>
                <div class="panel-body">
                    <ul id="factor-list" class="list-group">
                        <c:forEach var="factor" items="${experiment.factors}" varStatus="factorLoopStatus">
                            <li class="list-group-item li-factor-${factorLoopStatus.index}">
                                <div class="factor-item">
                                    <a class="accordion-toggle collapsed" href="#factor-levels-${factorLoopStatus.index}" data-toggle="collapse" aria-expanded="false" aria-controls="factor-levels-${factorLoopStatus.index}">
                                        <div class="factor-item-actions">
                                            <span class="factor-item-name">${factor.name}</span>
                                            <form:form id="editFactorForm-${factor.id}" method="POST" action="edit-factor" modelAttribute="editFactorForm-${factor.id}">
                                                <form:hidden path="id" />
                                                <button class="btn btn-default edit-button" type="submit">
                                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                </button>
                                            </form:form>
                                            <form:form id="removeFactorForm-${factor.id}" method="POST" action="remove-factor" modelAttribute="removeFactorForm-${factor.id}">
                                                <form:hidden path="id" />
                                                <button class="btn btn-default remove-button" type="submit">
                                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                </button>
                                            </form:form>
                                        </div>
                                    </a>
                                    <div class="factor-item-levels collapse" id="factor-levels-${factorLoopStatus.index}">
                                        <ul>
                                            <c:forEach var="level" items="${factor.levels}" varStatus="levelLoopStatus">
                                                <li class="list-group-item li-level-${levelLoopStatus.index}">
                                                    <div class="level-item-actions">
                                                        <span class="level-item-name">${level.name}</span>
                                                        <form:form id="editLevelForm-${level.id}" method="POST" action="edit-level" modelAttribute="editLevelForm-${level.id}">
                                                            <form:hidden path="id" />
                                                            <button class="btn btn-default edit-button" type="submit">
                                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                            </button>
                                                        </form:form>
                                                        <form:form id="removeLevelForm-${level.id}" method="POST" action="remove-level" modelAttribute="removeLevelForm-${level.id}">
                                                            <form:hidden path="id" />
                                                            <button class="btn btn-default remove-button" type="submit">
                                                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                            </button>
                                                        </form:form>
                                                    </div>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                        <form:form id="addLevelForm-${factor.id}" method="POST" action="add-level" modelAttribute="addLevelForm-${factor.id}">
                                            <form:hidden path="factorId" />
                                            <form:input path="name" type="text" placeholder="Level name"/>
                                            <form:errors path="name" />
                                            <button class="btn btn-default add-button" type="submit">
                                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                Add new Level
                                            </button>
                                        </form:form>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <form:form id="addFactorForm" method="POST" action="add-factor" modelAttribute="addFactorForm">
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
                    <form:form id="calculateForm" method="POST" action="calculate">
                        <button class="btn btn-lg btn-default" type="submit">Calculate</button>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="footer">Lorenzo603 &copy;2016</div>

        <div id="debug">
            DEBUG text
        </div>
    </div>

    <script type="text/javascript">

        $(document).ready(
            function() {
                ExperimentGridWidget.init();
            }
        );
    </script>
</body>
</html>
