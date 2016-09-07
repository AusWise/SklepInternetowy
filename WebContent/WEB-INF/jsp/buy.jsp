<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
	<meta charset="utf-8">
	<!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
	<title><spring:message code="page.buy.title" /></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="_menu.jsp" />

	<div class="container">
		<form:form modelAttribute="order" method="POST" class="form-horizontal" role="form">
			<legend>Shipping</legend>
		
			<div class="form-group">
				<label class="col-sm-3 control-label" for="card-holder-name"><spring:message code="page.buy.payment" /></label>
				<div class="col-sm-6">
					<form:select path="payment" class="form-control">
						<form:options items="${payments}"></form:options>
					</form:select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label" for="card-holder-name"><spring:message code="page.buy.delivery" /></label>
				<div class="col-sm-6">
					<form:select path="delivery" class="form-control">
						<form:options items="${deliveries}"></form:options>
					</form:select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button type="submit" class="btn btn-success"><spring:message code="page.buy.button" /></button>
				</div>
			</div>
			
		</form:form>
	</div>
</body>
</html>