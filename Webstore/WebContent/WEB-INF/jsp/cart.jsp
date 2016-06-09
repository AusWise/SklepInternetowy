<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title><spring:message code="page.cart.title"/></title>
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
        	<c:if test="${empty cart.cartItems}">
        		<spring:message code="page.cart.empty"/>
        	
        		<div class="row">
        			<a href="${pageContext.request.contextPath}/products">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span><spring:message code="page.cart.continue"/>
                        </button>
                  	</a>
        		</div>
        	
        	</c:if>
        
        
	        <c:if test="${not empty cart.cartItems}">
	            <table class="table table-hover">
	                <thead>
	                    <tr>
	                        <th><spring:message code="cart.cartItem.product"/></th>
	                        <th><spring:message code="cart.cartItem.quantity"/></th>
	                        <th class="text-center"><spring:message code="product.price"/></th>
	                        <th class="text-center"><spring:message code="cart.cartItem.total"/></th>
	                        <th> </th>
	                    </tr>
	                </thead>
	                <tbody>
                		<c:forEach var="cartItem" items="${cart.cartItems}">
                    	<tr>
                        	<td class="col-sm-8 col-md-6">
                        		<div class="media">
	                            	<a class="thumbnail pull-left" href="#">
	                            		<img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> 
	                            	</a>
	                            	<div class="media-body">
	                                	<h4 class="media-heading">
	                                		<a href="#">${cartItem.product}</a>
	                                	</h4>
	                                	
	                                	<h5 class="media-heading"> 
	                                		<spring:message code="cart.cartItem.by"/> 
	                                		<a href="#">${cartItem.product.producent}</a>
	                                	</h5>
	                            	</div>
                        		</div>
                        	</td>
                        
                        	<td class="col-sm-1 col-md-1" style="text-align: center">
                       			${cartItem.number}
                        	</td>
                        	
                        	<td class="col-sm-1 col-md-1 text-center">
                        		<strong>${cartItem.product.cena}</strong>
                        	</td>
                        
                        	<td class="col-sm-1 col-md-1 text-center">
                        		<strong>${cartItem.total}</strong>
                        	</td>
                        
                        	<td class="col-sm-1 col-md-1">
                        		<a href="${pageContext.request.contextPath}/cart/edit?id=${cartItem.product.ID}"> 
			                        <button type="button" class="btn btn-warning">
			                            <i class="glyphicon glyphicon-edit"></i>
			                        </button>
                        		</a>
                        
		                        <a href="${pageContext.request.contextPath}/cart/remove?id=${cartItem.product.ID}">
			                        <button type="button" class="btn btn-danger">
			                            <i class="glyphicon glyphicon-remove"></i>
			                        </button>
		                        </a>
                       		</td>
                    	</tr>
                    	</c:forEach>
                    
	                    <tr>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td>
	                        	<h3><spring:message code="cart.total"/></h3>
	                        </td>
	                        <td class="text-right">
	                        	<h3><strong>${cart.total}</strong></h3>
	                        </td>
	                    </tr>
                    
                    	<tr>
	                        <td></td>
	                        <td></td>
	                        <td></td>
                        	<td>
                        		<a href="${pageContext.request.contextPath}/products">
			                        <button type="button" class="btn btn-default">
			                            <span class="glyphicon glyphicon-shopping-cart"></span><spring:message code="page.cart.continue"/>
			                        </button>
                        		</a>
                        	</td>
                        
                        	<td>
                        		<a href="${pageContext.request.contextPath}/buy">
			                        <button type="button" class="btn btn-success">
			                            <spring:message code="page.cart.checkout"/><span class="glyphicon glyphicon-play"></span>
			                        </button>
                        		</a>
                        	</td>
                    	</tr>
                	</tbody>
            	</table>
            </c:if>
        	</div>
    	</div>
	</div>
</body>
</html>