<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/products"><spring:message code="page.main.title" text="default text" /></a>
    </div>
    <ul class="nav navbar-nav">
	    <li><a href="${pageContext.request.contextPath}/products"><spring:message code="page.products.title" text="default text" /></a></li>
		<li><a href="${pageContext.request.contextPath}/account"><spring:message code="page.account.title" text="default text" /></a></li>
		<li><a href="${pageContext.request.contextPath}/cart"><spring:message code="page.cart.title" text="default text" /></a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
    
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><spring:message code="locale.${pageContext.response.locale}" text="default text" />
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en_US&${pageContext.request.queryString}"><spring:message code="locale.en_US" text="default text" /></a></li>
          <li><a href="${requestScope['javax.servlet.forward.request_uri']}?lang=pl_PL&${pageContext.request.queryString}"><spring:message code="locale.pl_PL" text="default text" /></a></li>
        </ul>
      </li>
    
    <sec:authorize access="isAnonymous()">
    	<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> <spring:message code="page.login.title" text="default text" /></a></li>
    	<li><a href="${pageContext.request.contextPath}/registration"><span class="glyphicon glyphicon-user"></span> <spring:message code="page.registration.title" text="default text" /></a></li>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
    	<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span><spring:message code="logout" text="default text" /></a></li>
	</sec:authorize>
	</ul>
  </div>
</nav>
</body>
</html>
