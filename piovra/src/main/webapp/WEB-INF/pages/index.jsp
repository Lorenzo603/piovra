<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Piovra</title>
    
    <link rel="stylesheet" href="resources/css/lib/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    <script type="text/javascript" src="resources/js/lib/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="resources/js/lib/bootstrap.min.js"></script>
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
                    <div>
                        <button class="btn btn-default add-factor-button" type="button">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true">Add new factor</span>
                        </button>
                    </div>
                    <div class="hidden">
                        <form method="post" action="/addFactor">
                            <input name="factorName" type="text" />
                            <button>
                                <span class="glyphicon glyphicon-ok save-factor-button" aria-hidden="true"></span>
                            </button>
                            <button>
                                <span class="glyphicon glyphicon-remove clear-factor-button" aria-hidden="true"></span>
                            </button>
                        </form>
                    </div>

                </li>
            </ul>


            <br class="clear">
        </div>

        <div class="footer">Lorenzo603 &copy;2016</div>
        <div id="debug">

		</div>
    </div>

    <script type="text/javascript">
        $('.add-factor-button').click(
        function() {
            $(this.parentElement.parentElement).find('.hidden').removeClass('hidden');
        }
        );
        $('.save-factor-button').click(
        function() {
            $.ajax(
            {
                type: "POST",
                url: "/save-factor",
                data: null,
                success: function(){}
            }
            );
        }
        );

    </script>
</body>
</html>
