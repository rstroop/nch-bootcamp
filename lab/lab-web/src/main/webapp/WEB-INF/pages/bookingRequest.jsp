<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<spring:url value="/resources/css/theme.css" var="themeCSS" />
<spring:url
	value="/resources/bootstrap-3.3.4-dist/css/bootstrap.min.css"
	var="bootstrapCoreCSS" />
<spring:url
	value="/resources/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css"
	var="bootstrapThemeCSS" />
<spring:url value="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"
	var="bootstrapJS" />
<spring:url
	value="/resources/bootstrap-3.3.4-dist/js/bootstrap-datetimepicker.min.js"
	var="dateTimePickerJS" />
<spring:url
	value="/resources/bootstrap-3.3.4-dist/js/bootstrap-datetimepicker.pt-BR.js"
	var="dateTimePickerLocaleJS" />
<spring:url
	value="/resources/bootstrap-3.3.4-dist/css/bootstrap-datetimepicker.min.css"
	var="dateTimePickerCSS" />
<spring:url value="/resources/images/favicon.ico" var="favicon" />



<title>${message}</title>
<!-- Favicon -->
<link rel="icon" href="${favicon}">
<!-- Bootstrap core CSS -->
<link href="${bootstrapCoreCSS}" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="${bootstrapThemeCSS}" rel="stylesheet">
<!-- Bootstrap DateTime Picker -->
<link href="${dateTimePickerCSS}" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${themeCSS}" rel="stylesheet">

</head>

<body role="document">

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/lab-web">Associate Consultant Bootcamp</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Create
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Venue</a></li>
							<li><a href="/lab-web/bookingRequest">Booking Request</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container" role="main">


		<div class="page-header">
			<h1>Request a Booking</h1>
		</div>

		<form:form method="POST" commandName="bookingRequest">
			<div class="form-group">
				<label for="openTime">Opening Time</label>
				<div class="input-append date form_datetime">
					<form:input path="open"/> <span
						class="add-on"><i class="icon-th"></i></span>
				</div>
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea class="form-control" rows="5" id="description"
					path="performance.description"
					placeholder="Performance Description..." />
			</div>
			<button class="btn btn-lg btn-success pull-right" type="submit">Request</button>
		</form:form>
	</div>


	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${bootstrapJS}"></script>
	<script src="${dateTimePickerJS}"></script>
	<script src="${dateTimePickerLocaleJS}"></script>
	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			format : "dd-MM-yyyy hh:ii"
		});
	</script>
</body>
</html>
