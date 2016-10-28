<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Piovra - Login</title>

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
            <form:form id="loginForm" method="POST" action="my-account/doLogin" modelAttribute="loginForm">
                <form:input path="username" />
                <form:password path="password" />
                <button class="btn btn-lg btn-default" type="submit">Login</button>
            </form:form>
        </div>
        <div class="footer">Lorenzo603 &copy;2016</div>

        <div id="debug">
        </div>
    </div>


</body>
</html>
