<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<form:form method="POST" modelAttribute="cartItem" class="form-signin">
		<input name="id" type="hidden" value="${cartItem.product.ID}" }/>
		<table>
			<tr>
				<td>Product:</td>
				<td><jsp:text> ${cartItem.product} </jsp:text></td>
			</tr>
			<tr>
				<td>Number:</td>
				<td><form:input type="text" path="number" /></td>
			</tr>
		</table>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>