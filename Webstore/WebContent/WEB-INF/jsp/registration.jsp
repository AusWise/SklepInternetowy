<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-INF/jsp/style.css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    
</head>

<body>

	<%-- <jsp:include page="_menu.jsp" />
 --%>
	<div class="container">
		<div class="row centered-form">
			<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
        			<div class="panel-body">
        				<h3 class="panel-title">Registration</h3>
					</div>
				</div>
					
				<form:form method="POST" modelAttribute="user">
					<div class="panel panel-default">
      					<div class="panel-body">
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Imie" placeholder="Imie"/>
								<form:errors path="Imie"/>
							</div>
		
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Nazwisko" placeholder="Nazwisko"/>
								<form:errors path="Nazwisko"/>
							</div>
		
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="PESEL" placeholder="PESEL"/>
								<form:errors path="PESEL"/>
							</div>
			
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NIP" placeholder="NIP"/>
								<form:errors path="NIP"/>
							</div>
			
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NumerTelefonu" placeholder="NumerTelefonu"/>
								<form:errors path="NumerTelefonu"/>
							</div>
			
							<div class="form-group">	
								<form:input cssClass="form-control input-sm" path="Email" placeholder="Email"/>
								<form:errors path="Email"/>
							</div>
						</div>
					</div>
							
					<div class="panel panel-default">
        				<div class="panel-body">
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Ulica" placeholder="Ulica"/>
								<form:errors path="Ulica"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NrBudynku" placeholder="NrBudynku"/>
								<form:errors path="NrBudynku"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NrLokalu" placeholder="NrLokalu"/>
								<form:errors path="NrBudynku"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Miasto" placeholder="Miasto"/>
								<form:errors path="Miasto"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="KodPocztowy" placeholder="KodPocztowy"/>
								<form:errors path="KodPocztowy"/>
							</div>
						</div>
					</div>
							
					<div class="panel panel-default">
        				<div class="panel-body">
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="login" placeholder="login"/>
								<form:errors path="login"/>
							</div>
							
							<div class="form-group">
								<form:password cssClass="form-control input-sm" path="haslo" placeholder="haslo"/>
								<form:errors path="haslo"/>
							</div>
							
							<div class="form-group">
								<form:password cssClass="form-control input-sm" path="passwordConfirm" placeholder="passwordConfirm"/>
								<form:errors path="passwordConfirm"/>
							</div>
						</div>
					</div>
				
					<div class="panel panel-default">
        				<div class="panel-body">
							<button type="submit" class="btn btn-info btn-block">Register</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>

</html>