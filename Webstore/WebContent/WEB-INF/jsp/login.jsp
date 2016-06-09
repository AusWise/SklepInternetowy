<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	
	<title><spring:message code="page.login.title"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>

<body>
	<jsp:include page="_menu.jsp" />

	<!-- <div id="login-box"> -->

	<div class="container">
		<div class="row centered-form">
			<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
        			<div class="panel-body">
        			
	        			<h2><spring:message code="page.login.title"/></h2>
	
						<c:if test="${not empty error}">
							<div class="error"><spring:message code="Invalid.user.loginpassword"/></div>
						</c:if>
						
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
					
						<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
							<!-- <table>
								<tr> <td>User:</td> <td><input type='text' name='username'></td> </tr>
								<tr> <td>Password:</td> <td><input type='password' name='password' /></td> </tr>
								<tr> <td colspan='2'><input name="submit" type="submit" value="Sign In" /></td> </tr>
							</table> -->
							
							<div class="form-group">
								<input type='text' class="form-control input-sm" name='username' placeholder=<spring:message code="page.login.username" /> />
							</div>
							
							<div class="form-group">
								<input type='password' class="form-control input-sm" name='password' placeholder=<spring:message code="page.login.password" /> />
							</div>
							
							<button type="submit" class="btn btn-info btn-block"><spring:message code="page.login.submit"/></button>
							
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
        			
        			</div>
        		</div>
        	</div>
        </div>
	</div>

	
	<!-- </div> -->

</body>
</html>