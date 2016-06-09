<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</html> --%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title><spring:message code="page.cart.title"/></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="_menu.jsp" />
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
            <thead>
                    <tr>
                        <th><spring:message code="cart.cartItem.product"/></th>
                        <th><spring:message code="cart.cartItem.quantity"/></th>
                        
                        <th> </th>
                    </tr>
                </thead>
            <tbody>
<form:form method="POST" modelAttribute="cartItem">
<tr>

    <td class="col-md-6">
    
    <div class="media">
        <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
        <div class="media-body">
            <h4 class="media-heading"><a href="#">${cartItem.product}</a></h4>
            <h5 class="media-heading"> by <a href="#">${cartItem.product.producent}</a></h5>
            
        </div>
    </div>
    
    </td>
    <td class="col-md-1" style="text-align: center">
  	<form:hidden path="product"/>
    <form:input path="number" />
    </td>
    
    <td class="col-md-1">
    <button type="submit" class="btn btn-success">
        <i class="glyphicon glyphicon-ok"></i> 
    </button></td>
    
</tr>
</form:form>
</tbody>
</table>

</div>
</div>
</div>
</body>
</html>