<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
	<title><spring:message code="edit"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>

<body>
	<jsp:include page="_menu.jsp" />
  
	<div class="container">
		<div class="row centered-form">
			<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
        			<div class="panel-body">
        				<h3 class="panel-title"><spring:message code="edit"/></h3>
					</div>
				</div>
					
				<form:form method="POST" modelAttribute="user">
					<div class="panel panel-default">
      					<div class="panel-body">
      						<div class="form-group">
								<form:hidden path="rola"/>
							</div>
							
							<div class="form-group">
								<form:hidden path="ID"/>
							</div>
      					
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
								<form:input cssClass="form-control input-sm" path="login" placeholder="login" readOnly="true"/>
								<form:errors path="login"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="haslo" placeholder="haslo"/>
								<form:errors path="haslo"/>
							</div>
						</div>
					</div>
				
					<div class="panel panel-default">
        				<div class="panel-body">
							<button type="submit" class="btn btn-info btn-block"><spring:message code="accept"/></button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>

</html>