<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<form:form method="POST" modelAttribute="product" class="form-signin">
		<table>
			<tr>
				<td>ID:</td>
				<td><form:input type="text" path="ID" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Nazwa:</td>
				<td><form:input type="text" path="Nazwa" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Opis:</td>
				<td><form:input type="text" path="Opis" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Cena:</td>
				<td><form:input type="text" path="Cena" class="form-control"></form:input></td>
			</tr>

			<tr>
				<td>Typ produktu:</td>
				<td><form:select path="typProduktu">
						<form:options items="${productTypes}" />
					</form:select></td>
			</tr>

			<tr>
				<td>Producent:</td>
				<td><form:select path="producent">
						<form:options items="${producers}" />
					</form:select></td>
			</tr>
		</table>

		<button type="submit">Submit</button>

	</form:form>

</body>
</html>