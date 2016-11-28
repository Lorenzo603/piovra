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

        <table id="casesTable" class="display" width="100%">
            <thead>
                <tr role="row">
                    <c:forEach var="factorName" items="${suite.factorNames}">
                        <th role="columnheader">${factorName}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

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
               ExperimentResultWidget.init();
           }
       );

    </script>
</template:page>
