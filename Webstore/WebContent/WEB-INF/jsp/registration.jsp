<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Registration form - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body{
    background-color: #525252;
}
.centered-form{
	margin-top: 60px;
}

.centered-form .panel{
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<div class="row centered-form">
<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
<div class="panel panel-default">
        		<div class="panel-heading">
        		<h3 class="panel-title">Please sign up for Bootsnipp <small>It's free!</small></h3>
				</div>
				<div class="panel-body">
	<form:form method="POST" modelAttribute="user">
		<table>
			<tr>
				<td>Imie:</td>
				<td>
				<div class="form-group">
				<form:input cssClass="form-control input-sm" path="Imie"/>
				</div>
				</td>
				<td><form:errors path="Imie"/></td>
			</tr>
			
			<tr>
				<td>Nazwisko:</td>
				<td><form:input path="Nazwisko"/></td>
				<td><form:errors path="Nazwisko"/></td>
			</tr>
			<tr>
				<td>PESEL:</td>
				<td><form:input path="PESEL"/></td>
				<td><form:errors path="PESEL"/></td>
			</tr>
			<tr>
				<td>NIP:</td>
				<td><form:input path="NIP"/></td>
				<td><form:errors path="NIP"/></td>
			</tr>
			<tr>
				<td>Numer telefonu:</td>
				<td><form:input path="NumerTelefonu"/></td>
				<td><form:errors path="NumerTelefonu"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="Email"/></td>
				<td><form:errors path="Email"/></td>
			</tr>
			<tr>
				<td>Ulica:</td>
				<td><form:input path="Ulica"/></td>
				<td><form:errors path="Ulica"/></td>
			</tr>
			<tr>
				<td>Numer budynku:</td>
				<td><form:input path="NrBudynku"/></td>
				<td><form:errors path="NrBudynku"/></td>
			</tr>
			<tr>
				<td>Numer lokalu:</td>
				<td><form:input path="NrLokalu"/></td>
				<td><form:errors path="NrBudynku"/></td>
				
			</tr>
			<tr>
				<td>Miasto:</td>
				<td><form:input path="Miasto"/></td>
				<td><form:errors path="Miasto"/></td>
			</tr>
			<tr>
				<td>Kod pocztowy:</td>
				<td><form:input path="KodPocztowy"/></td>
				<td><form:errors path="KodPocztowy"/></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><form:input path="login"/></td>
				<td><form:errors path="login"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="haslo"/></td>
				<td><form:errors path="haslo"/></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><form:password path="passwordConfirm"/></td>
				<td><form:errors path="passwordConfirm"/></td>
			</tr>
		</table>

		<button type="submit">Submit</button>
	</form:form>
	</div>
</div>
</div>
</div>
</div>
</body>
</html>