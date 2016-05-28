<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
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
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="_menu.jsp" />

<div class="container">
	<div class="span8">
		<c:forEach var="product" items="${products}">
	        <h1><jsp:text>${product.nazwa}</jsp:text></h1>
	        <table>
	        	<tr> <td>Typ produktu: </td> <td><jsp:text>${product.typProduktu}</jsp:text></td> </tr>
	        	<tr> <td>Producent: </td> <td><jsp:text>${product.producent}</jsp:text></td> </tr>
	        	<tr> <td>Cena: </td> <td><jsp:text>${product.cena}</jsp:text></td> </tr>
	        	<tr> <td>Opis: </td> <td><jsp:text>${product.opis}</jsp:text></td> </tr>
	        </table>
	        <div class="more label"><a href="#">Read more</a></div> 
	        <div class="clear"></div>
	        <hr>
        </c:forEach>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>