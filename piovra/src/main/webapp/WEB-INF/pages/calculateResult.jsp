<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Piovra - Calculation result</title>

    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    <script type="text/javascript" src="resources/js/lib/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/mustache.min.js"></script>
    <script type="text/javascript" src="resources/js/experimentGridWidget.js"></script>
</head>
<body>

List of cases:<br>
<table>
    <c:forEach var="caseList" items="${suite.cases}">
        <tr>
            <c:forEach var="levelName" items="${caseList}">
                <td>${levelName}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>