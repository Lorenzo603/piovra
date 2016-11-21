<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>

    <div class="breadcrumbs">
        <c:url value="/my-account/experiment/${suite.experimentId}" var="experimentUrl"/>
        <a href="${experimentUrl}">
            <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
            Back to experiment page
        </a>
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
            <tr>
                <th></th>
                <th></th>
                <c:forEach var="factorName" items="${suite.factorNames}">
                    <th>${factorName}</th>
                </c:forEach>
            </tr>
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
