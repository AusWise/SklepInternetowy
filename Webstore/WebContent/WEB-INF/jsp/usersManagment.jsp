<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Rola</th>
			<th>Imie</th>
			<th>Nazwisko</th>
			<th>PESEL</th>
			<th>NIP</th>
			<th>Numer Telefonu</th>
			<th>Email</th>
			<th>Ulica</th>
			<th>Numer budynku</th>
			<th>Numer lokalu</th>
			<th>Miasto</th>
			<th>Kod pocztowy</th>
			<th>Login</th>
			<th>Hasło</th>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>
				<td><jsp:text>${user.ID }</jsp:text></td>
				<td><jsp:text>${user.rola }</jsp:text></td>
				<td><jsp:text>${user.imie }</jsp:text></td>
				<td><jsp:text>${user.nazwisko }</jsp:text></td>
				<td><jsp:text>${user.PESEL }</jsp:text></td>
				<td><jsp:text>${user.NIP }</jsp:text></td>
				<td><jsp:text>${user.numerTelefonu }</jsp:text></td>
				<td><jsp:text>${user.email }</jsp:text></td>
				<td><jsp:text>${user.ulica }</jsp:text></td>
				<td><jsp:text>${user.nrBudynku }</jsp:text></td>
				<td><jsp:text>${user.nrLokalu }</jsp:text></td>
				<td><jsp:text>${user.miasto }</jsp:text></td>
				<td><jsp:text>${user.kodPocztowy }</jsp:text></td>
				<td><jsp:text>${user.login }</jsp:text></td>
				<td><jsp:text>${user.haslo }</jsp:text></td>

				<td><a
					href="${pageContext.request.contextPath}/usersManagment/edit?id=${userListCmd.userList[status.index].ID}">
						edit </a></td>
				<td><a
					href="${pageContext.request.contextPath}/usersManagment/remove?id=${userListCmd.userList[status.index].ID}">
						remove </a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/usersManagment/new">new
		User </a>
</body>
</html>