<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="_menu.jsp" />

	<div class="container">
	
	<a href="${pageContext.request.contextPath}/productsManagment/new">
				<button class="btn btn-sm btn-success" type="button"><i class="glyphicon glyphicon-plus"></i></button>
			</a>
	
	<table class="table">
		<tr>
			<th><spring:message code="product.name"/></th>
			<th><spring:message code="product.productType"/></th>
			<th><spring:message code="product.producer"/></th>
			<th><spring:message code="product.description"/></th>
			<th><spring:message code="product.price"/></th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.ID}
				</td>
				<td>${product.nazwa}
				</td>
				<td>${product.typProduktu}
				</td>
				<td>${product.producent}
				</td>
				<td>${product.opis}
				</td>
				<td>${product.cena}
				</td>
				<td><a
					href="${pageContext.request.contextPath}/productsManagment/edit?id=${product.ID}">
						<spring:message code="edit"/> </a></td>
				<td><a
					href="${pageContext.request.contextPath}/productsManagment/remove?id=${product.ID}">
						<spring:message code="remove"/> </a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>