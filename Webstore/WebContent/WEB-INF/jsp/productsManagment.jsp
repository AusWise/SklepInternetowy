<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<table>
		<tr>
			<th>Nazwa</th>
			<th>Typ produktu</th>
			<th>Producent</th>
			<th>Opis</th>
			<th>Cena</th>
			<th></th>
		</tr>

		<c:forEach var="product" items="${products}">
			<tr>
				<td><jsp:text>${product.ID}</jsp:text>
				<td>
				<td><jsp:text>${product.nazwa}</jsp:text>
				<td>
				<td><jsp:text>${product.typProduktu}</jsp:text>
				<td>
				<td><jsp:text>${product.producent}</jsp:text>
				<td>
				<td><jsp:text>${product.opis}</jsp:text>
				<td>
				<td><jsp:text>${product.cena}</jsp:text>
				<td>
				<td><a
					href="${pageContext.request.contextPath}/productManagment/edit?id=${product.ID}">
						edit </a></td>
				<td><a
					href="${pageContext.request.contextPath}/productManagment/remove?id=${product.ID}">
						remove </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>