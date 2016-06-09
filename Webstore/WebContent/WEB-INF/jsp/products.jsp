<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><spring:message code="page.products.title"></spring:message></title>
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style type="text/css">
        .clear {
		    clear:both;    
		}
		.btn-info {
		    margin-right:15px;
		    text-transform:uppercase;
		    padding:10px;
		    display:block;
		    float:left;
		}
		.btn-info a {
		    display:block;
		    text-decoration:none;
		    width:100%;
		    height:100%;
		    color:#fff;
		}
		.more.label {
		    float:right;    
		}
    </style>
    
</head>
<body>

<jsp:include page="_menu.jsp" />

<div class="container">
	<div class="span8">
		<c:forEach var="product" items="${products}">
	        <h1>${product.nazwa}</h1>
	        <table>
	        	<tr> <td><spring:message code="product.productType"></spring:message>: </td> <td>${product.typProduktu}</td> </tr>
	        	<tr> <td><spring:message code="product.producer"></spring:message>: </td> <td>${product.producent}</td> </tr>
	        	<tr> <td><spring:message code="product.price"></spring:message>: </td> <td>${product.cena}</td> </tr>
	        	<tr> <td><spring:message code="product.description"></spring:message>: </td> <td>${product.opis}</td> </tr>
	        </table>
	        <div class="more label"><a href="${pageContext.request.contextPath}/cart/add?id=${product.ID}"><spring:message code="page.products.addToCart"></spring:message></a></div> 
	        <div class="clear"></div>
	        <hr>
        </c:forEach>
    </div>
</div>


</body>
</html>