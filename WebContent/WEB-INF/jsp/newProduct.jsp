<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />"> --%>
</head>

<body>

	<jsp:include page="_menu.jsp" />
	
	<div class="container">
	
	<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
	<form:form method="POST" modelAttribute="product">
		
		<table class="table">
			<tr>
				<td><spring:message code="product.name"/>:</td>
				<td><form:input type="text" path="Nazwa"></form:input></td>
			</tr>
			<tr>
				<td><spring:message code="product.description"/>:</td>
				<td><form:input type="text" path="Opis"></form:input></td>
			</tr>
			<tr>
				<td><spring:message code="product.price"/>:</td>
				<td><form:input type="text" path="Cena"></form:input></td>
			</tr>

			<tr>
				<td><spring:message code="product.productType"/>:</td>
				<td><form:select path="typProduktu">
						<form:options items="${productTypes}" />
					</form:select></td>
			</tr>

			<tr>
				<td><spring:message code="product.producer"/>:</td>
				<td><form:select path="producent">
						<form:options items="${producers}" />
					</form:select></td>
			</tr>
		</table>
		
		<button type="submit">Submit</button>
	

	</form:form>
	</div>
	</div>

</body>
</html>