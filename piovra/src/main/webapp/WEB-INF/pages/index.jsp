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
    <script type="text/javascript" src="resources/js/experimentGridWidget.js"></script>
</head>
<body>
    <div id="wrapper">
        <div class="top">
			<a href="/">
				<img class="piovra-logo" src="resources/img/piovra-logo.png"/>
			</a>
			<h1>Piovra</h1>
			<br class="clear">
		</div>

        <div class="content">
            <ul id="factor-list" class="list-group">
                <c:forEach var="factor" items="${experiment.factors}" varStatus="factorLoopStatus">
                    <li class="list-group-item li-factor-${factorLoopStatus.index}">
                        <div class="factor-item">
                            Factor name: ${factor.name}
                            <form:form id="editFactorForm-${factor.id}" method="POST" action="edit-factor" modelAttribute="editFactorForm-${factor.id}">
                                <form:hidden path="id" />
                                <button class="edit-factor-button" type="submit">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                            </form:form>
                            <form:form id="removeFactorForm-${factor.id}" method="POST" action="remove-factor" modelAttribute="removeFactorForm-${factor.id}">
                                <form:hidden path="id" />
                                <button class="remove-factor-button" type="submit">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </button>
                            </form:form>
                            <ul>
                                <c:forEach var="level" items="${factor.levels}" varStatus="levelLoopStatus">
                                    <li class="list-group-item li-level-${levelLoopStatus.index}">
                                        <div class="level-item">
                                            Level name: ${level.name}
                                            <form:form id="editLevelForm-${level.id}" method="POST" action="edit-level" modelAttribute="editLevelForm-${level.id}">
                                                <form:hidden path="id" />
                                                <button class="edit-level-button" type="submit">
                                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                </button>
                                            </form:form>
                                            <form:form id="removeLevelForm-${level.id}" method="POST" action="remove-level" modelAttribute="removeLevelForm-${level.id}">
                                                <form:hidden path="id" />
                                                <button class="remove-level-button" type="submit">
                                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                </button>
                                            </form:form>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                            <form:form id="addLevelForm-${factor.id}" method="POST" action="add-level" modelAttribute="addLevelForm-${factor.id}">
                                <form:hidden path="factorId" />
                                Level name:
                                <form:input path="name" type="text" />
                                <form:errors path="name" />
                                <button class="btn btn-default add-level-button" type="submit">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true">Add new Level</span>
                                </button>
                            </form:form>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <form:form id="addFactorForm" method="POST" action="add-factor" modelAttribute="addFactorForm">
                Factor name:
                <form:input path="name" type="text" />
                <form:errors path="name" />
                <button class="btn btn-default add-factor-button" type="submit">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true">Add new factor</span>
                </button>
            </form:form>
            <div class="clear" />

            <div>
                <form:form id="calculateForm" method="POST" action="calculate">
                    <button class="btn btn-default" type="submit">Calculate</button>
                </form:form>
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
