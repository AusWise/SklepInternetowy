<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<form:form method="POST" modelAttribute="user" class="form-signin">
		<table>
			<tr>
				<td>ID:</td>
				<td><form:input type="text" path="ID" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Imie:</td>
				<td><form:input type="text" path="Imie" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Nazwisko:</td>
				<td><form:input type="text" path="Nazwisko"
						class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>PESEL:</td>
				<td><form:input type="text" path="PESEL" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>NIP:</td>
				<td><form:input type="text" path="NIP" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Numer telefonu:</td>
				<td><form:input type="text" path="NumerTelefonu"
						class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" path="Email" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Ulica:</td>
				<td><form:input type="text" path="Ulica" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Numer budynku:</td>
				<td><form:input type="text" path="NrBudynku"
						class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Numer lokalu:</td>
				<td><form:input type="text" path="NrLokalu"
						class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Miasto:</td>
				<td><form:input type="text" path="Miasto" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Kod pocztowy:</td>
				<td><form:input type="text" path="KodPocztowy"
						class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><form:input type="text" path="login" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="text" path="haslo" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Rola:</td>
				<td><form:select path="rola">
						<form:options items="${roles}" />
					</form:select></td>
			</tr>
		</table>

		<button type="submit">Submit</button>

	</form:form>

</body>
</html> --%>

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
					
				<spring:message code="user.firstName" var="firstName"/>
				<spring:message code="user.lastName" var="lastName"/>	
				<spring:message code="user.pesel" var="pesel"/>
				<spring:message code="user.nip" var="nip"/>
				<spring:message code="user.phone" var="phone"/>
				<spring:message code="user.email" var="email"/>
				<spring:message code="user.streetName" var="streetName"/>
				<spring:message code="user.buildingNumber" var="buildingNumber"/>
				<spring:message code="user.flatNumber" var="flatNumber"/>
				<spring:message code="user.city" var="city"/>
				<spring:message code="user.postalCode" var="postalCode"/>
				<spring:message code="user.username" var="username"/>
				<spring:message code="user.password" var="password"/>
				<spring:message code="page.registration.passwordConfirm" var="passwordConfirm"/>	
					
				<form:form method="POST" modelAttribute="user">
					<div class="panel panel-default">
      					<div class="panel-body">
							<div class="form-group">
								<form:select path="rola">
									<option>Rola</option>
									<form:options items="${roles}" />
								</form:select>
								<form:errors path="rola"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="ID" placeholder="ID" readOnly="true"/>
								<form:errors path="ID"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Imie" placeholder="${firstName}" />
								<form:errors path="Imie"/>
							</div>
		
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Nazwisko" placeholder="${lastName}" />
								<form:errors path="Nazwisko"/>
							</div>
		
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="PESEL" placeholder="${pesel}" />
								<form:errors path="PESEL"/>
							</div>
			
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NIP" placeholder="${nip}" />
								<form:errors path="NIP"/>
							</div>
			
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NumerTelefonu" placeholder="${phone}" />
								<form:errors path="NumerTelefonu"/>
							</div>
			
							<div class="form-group">	
								<form:input cssClass="form-control input-sm" path="Email" placeholder="${email}" />
								<form:errors path="Email"/>
							</div>
						</div>
					</div>
							
					<div class="panel panel-default">
        				<div class="panel-body">
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Ulica" placeholder="${streetName}" />
								<form:errors path="Ulica"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NrBudynku" placeholder="${buildingNumber}" />
								<form:errors path="NrBudynku"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="NrLokalu" placeholder="${flatNumber}" />
								<form:errors path="NrBudynku"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="Miasto" placeholder="${city}" />
								<form:errors path="Miasto"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="KodPocztowy" placeholder="${postalCode}" />
								<form:errors path="KodPocztowy"/>
							</div>
						</div>
					</div>
							
					<div class="panel panel-default">
        				<div class="panel-body">
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="login" placeholder="${username}" />
								<form:errors path="login"/>
							</div>
							
							<div class="form-group">
								<form:input cssClass="form-control input-sm" path="haslo" placeholder="${password}" />
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
