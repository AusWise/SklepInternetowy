<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<c:if test="${empty param.id}">
	ble
</c:if>

<c:if test="${not empty param.id}">
	${param.id}
</c:if>

</body>
</html>