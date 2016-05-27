<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

	<form:form method="POST" modelAttribute="user" class="form-signin">
		<table>
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
				<td>Password:</td>
				<td><form:input type="text" path="haslo" class="form-control"></form:input></td>
			</tr>

		</table>

		<button type="submit">Submit</button>

	</form:form>

</body>
</html>