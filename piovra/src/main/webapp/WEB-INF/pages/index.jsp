<%@ taglib prefix="experimentGrid" tagdir="/WEB-INF/tags/experimentGrid" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Piovra</title>

    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    <script type="text/javascript" src="resources/js/lib/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/bootstrap.min.js"></script>
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
                <li class="list-group-item">
                    <experimentGrid:factorItem />
                </li>
            </ul>
            <div>
                <button class="btn btn-default add-factor-button" type="button">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true">Add new factor</span>
                </button>
            </div>

            <br class="clear">
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
