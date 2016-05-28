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

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gun WebStore</a>
    </div>
    <ul class="nav navbar-nav">
	    <li><a href="${pageContext.request.contextPath}/products">Products</a></li>
		<li><a href="${pageContext.request.contextPath}/account">User</a></li>
		<li><a href="${pageContext.request.contextPath}/employee">Employee</a></li>
		<li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
		<li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
    	<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    	<li><a href="${pageContext.request.contextPath}/registration"><span class="glyphicon glyphicon-user"></span> Signup</a></li>
    </ul>
  </div>
</nav>
</body>
</html>
