<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Products</title>
</head>
<body>
   <c:forEach var="product" items="${listProduct}" varStatus="status">
   		<p>${product.name}</p>
   </c:forEach>
</body>
</html>