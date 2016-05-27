<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
	<table>
		<tr>
			<td>Imie:</td>
			<td><jsp:text> ${user.imie} </jsp:text></td>
		</tr>
		<tr>
			<td>Nazwisko:</td>
			<td><jsp:text> ${user.nazwisko} </jsp:text></td>
		</tr>
		<tr>
			<td>PESEL:</td>
			<td><jsp:text> ${user.PESEL} </jsp:text></td>
		</tr>
		<tr>
			<td>NIP:</td>
			<td><jsp:text> ${user.NIP} </jsp:text></td>
		</tr>
		<tr>
			<td>Numer telefonu:</td>
			<td><jsp:text> ${user.numerTelefonu} </jsp:text></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><jsp:text> ${user.email} </jsp:text></td>
		</tr>
		<tr>
			<td>Ulica:</td>
			<td><jsp:text> ${user.ulica} </jsp:text></td>
		</tr>
		<tr>
			<td>Numer budynku:</td>
			<td><jsp:text> ${user.nrBudynku} </jsp:text></td>
		</tr>
		<tr>
			<td>Numer lokalu:</td>
			<td><jsp:text> ${user.nrLokalu} </jsp:text></td>
		</tr>
		<tr>
			<td>Miasto:</td>
			<td><jsp:text> ${user.miasto} </jsp:text></td>
		</tr>
		<tr>
			<td>Kod pocztowy:</td>
			<td><jsp:text> ${user.kodPocztowy} </jsp:text></td>
		</tr>
		<tr>
			<td>Login:</td>
			<td><jsp:text> ${user.login} </jsp:text></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>${user.haslo}</td>
		</tr>

	</table>
	<p>
		<a href="${pageContext.request.contextPath}/account/edit">Edit
			Account</a>
	</p>

</body>
</html>