<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Piovra - Calculation result</title>

    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    <script type="text/javascript" src="resources/js/lib/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/bootstrap.min.js"></script>
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
            <h1>List of cases:</h1>
            <div class="export-actions">
                <a id="export-to-excel-link" href="export-to-excel">
                    <button class="btn btn-success" type="submit">
                        <span class="glyphicon glyphicon-download-alt" aria-hidden="true" ></span>
                        Export to Excel
                    </button>
                </a>
            </div>
            <table class="table table-striped table-bordered">
                <c:forEach var="caseList" items="${suite.cases}" varStatus="status">
                    <tr id="tr-case-${status.index}">
                        <th class="fit">
                            <input id="checkbox-case-${status.index}" type="checkbox">
                        </th>
                        <th class="fit">Case ${status.count}</th>
                        <c:forEach var="levelName" items="${caseList}">
                            <td>${levelName}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="footer">Lorenzo603 &copy;2016</div>
        <div id="debug">
        </div>
    </div>

    <script type="text/javascript">

        $(document).ready(
            function() {
                $('input[type="checkbox"]').change(
                function() {
                        var caseIndex = $(this).attr('id').split("-")[2];
                        if (this.checked) {
                            $('#tr-case-'+caseIndex).addClass('case-considered');
                        } else {
                            $('#tr-case-'+caseIndex).removeClass('case-considered');
                        }
                    }
                );
        });

    </script>
</body>
</html>