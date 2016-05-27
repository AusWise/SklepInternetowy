<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<form:form modelAttribute="cart" method="POST">
		<table>
			<tr>
				<th>Product</th>
				<th>Number</th>
			</tr>
			<c:forEach var="cartItem" items="${cart.cartItems}">
				<tr>
					<td><jsp:text> ${cartItem.product} </jsp:text></td>
					<td><jsp:text> ${cartItem.number} </jsp:text></td>
					<td><a
						href="${pageContext.request.contextPath}/cart/edit?id=${cartItem.product.ID}">
							Edit </a></td>
					<td><a
						href="${pageContext.request.contextPath}/cart/remove?id=${cartItem.product.ID}">
							Remove </a></td>
				</tr>
			</c:forEach>
		</table>
		<td><a href="${pageContext.request.contextPath}/cart/clear">
				Clear </a></td>
	</form:form>

</body>
</html>