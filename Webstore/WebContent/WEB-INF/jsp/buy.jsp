<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<form:form modelAttribute="order" method="POST" class="form-signin">

		<form:select path="payment">
			<form:options itemValue="ID" itemLabel="nazwa" items="${payments}"></form:options>
		</form:select>


		<form:select path="delivery">
			<form:options itemValue="ID" itemLabel="nazwa" items="${deliveries}"></form:options>
		</form:select>

		<button type="submit">Submit</button>
	</form:form>
</body>
</html>