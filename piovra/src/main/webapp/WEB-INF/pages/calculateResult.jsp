<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<template:page>

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
</template:page>