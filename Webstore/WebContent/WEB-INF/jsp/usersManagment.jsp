<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Rola</th>
			<th>Imie</th>
			<th>Nazwisko</th>
			<th>PESEL</th>
			<th>NIP</th>
			<th>Numer Telefonu</th>
			<th>Email</th>
			<th>Ulica</th>
			<th>Numer budynku</th>
			<th>Numer lokalu</th>
			<th>Miasto</th>
			<th>Kod pocztowy</th>
			<th>Login</th>
			<th>Hasło</th>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>
				<td><jsp:text>${user.ID }</jsp:text></td>
				<td><jsp:text>${user.rola }</jsp:text></td>
				<td><jsp:text>${user.imie }</jsp:text></td>
				<td><jsp:text>${user.nazwisko }</jsp:text></td>
				<td><jsp:text>${user.PESEL }</jsp:text></td>
				<td><jsp:text>${user.NIP }</jsp:text></td>
				<td><jsp:text>${user.numerTelefonu }</jsp:text></td>
				<td><jsp:text>${user.email }</jsp:text></td>
				<td><jsp:text>${user.ulica }</jsp:text></td>
				<td><jsp:text>${user.nrBudynku }</jsp:text></td>
				<td><jsp:text>${user.nrLokalu }</jsp:text></td>
				<td><jsp:text>${user.miasto }</jsp:text></td>
				<td><jsp:text>${user.kodPocztowy }</jsp:text></td>
				<td><jsp:text>${user.login }</jsp:text></td>
				<td><jsp:text>${user.haslo }</jsp:text></td>

				<td><a
					href="${pageContext.request.contextPath}/usersManagment/edit?id=${userListCmd.userList[status.index].ID}">
						edit </a></td>
				<td><a
					href="${pageContext.request.contextPath}/usersManagment/remove?id=${userListCmd.userList[status.index].ID}">
						remove </a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/usersManagment/new">new
		User </a>
</body>
</html> --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title><spring:message code="page.admin.title"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style type="text/css">
        .user-row {
		    margin-bottom: 14px;
		}
		
		.user-row:last-child {
		    margin-bottom: 0;
		}
		
		.dropdown-user {
		    margin: 13px 0;
		    padding: 5px;
		    height: 100%;
		}
		
		.dropdown-user:hover {
		    cursor: pointer;
		}
		
		.table-user-information > tbody > tr {
		    border-top: 1px solid rgb(221, 221, 221);
		}
		
		.table-user-information > tbody > tr:first-child {
		    border-top: 0;
		}
		
		
		.table-user-information > tbody > tr > td {
		    border-top: 0;
		}
    </style>
    
</head>
<body>
	
	<jsp:include page="_menu.jsp" />

	<br><br>
	
	<div class="container">
 		<div class="well col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
 			<div class="row user-row">
 			<a href="${pageContext.request.contextPath}/usersManagment/new">
				<button class="btn btn-sm btn-success" type="button"><i class="glyphicon glyphicon-plus"></i></button>
			</a>
			</div>
		 		
 			<c:forEach var="user" items="${users}">
		        <div class="row user-row">
		            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
		                <img class="img-circle"
		                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
		                     alt="User Pic">
		            </div>
		            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
		                <strong>${user.login}</strong><br>
		                <span class="text-muted"><spring:message code="user.role"/>: ${user.rola.nazwa} </span>
		            </div>
		            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".${user.ID}">
		                <i class="glyphicon glyphicon-chevron-down text-muted"></i>
		            </div>
		        </div>
		        
		        <div class="row user-infos ${user.ID}">
		            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
		                <div class="panel panel-primary">
		                    <div class="panel-heading">
		                        <h3 class="panel-title"><spring:message code="page.admin.information"/></h3>
		                    </div>
		                    <div class="panel-body">
		                        <div class="row">
		                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
		                                <img class="img-circle"
		                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
		                                     alt="User Pic">
		                            </div>
		                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
		                                <img class="img-circle"
		                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
		                                     alt="User Pic">
		                            </div>
		                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
		                                <strong>${user.login }</strong><br>
		                                <table class="table table-user-information">
		                                    <tbody>
                      <tr>
							<td><spring:message code="user.firstName"/>:</td>
							<td> ${user.imie} </td>
						</tr>
						<tr>
							<td><spring:message code="user.lastName"/>:</td>
							<td> ${user.nazwisko} </td>
						</tr>
						<tr>
							<td><spring:message code="user.pesel"/>:</td>
							<td> ${user.PESEL} </td>
						</tr>
						<tr>
							<td><spring:message code="user.nip"/>:</td>
							<td> ${user.NIP} </td>
						</tr>
						<tr>
							<td><spring:message code="user.phone"/>:</td>
							<td> ${user.numerTelefonu} </td>
						</tr>
						<tr>
							<td><spring:message code="user.email"/>:</td>
							<td> ${user.email} </td>
						</tr>
						<tr>
							<td><spring:message code="user.streetName"/>:</td>
							<td> ${user.ulica} </td>
						</tr>
						<tr>
							<td><spring:message code="user.buildingNumber"/>:</td>
							<td> ${user.nrBudynku} </td>
						</tr>
						<tr>
							<td><spring:message code="user.flatNumber"/>:</td>
							<td> ${user.nrLokalu} </td>
						</tr>
						<tr>
							<td><spring:message code="user.city"/>:</td>
							<td> ${user.miasto} </td>
						</tr>
						<tr>
							<td><spring:message code="user.postalCode"/>:</td>
							<td> ${user.kodPocztowy} </td>
						</tr>
						<tr>
							<td><spring:message code="user.username"/>:</td>
							<td> ${user.login} </td>
						</tr>
						<tr>
							<td><spring:message code="user.password"/>:</td>
							<td>${user.haslo}</td>
						</tr>
                    </tbody>
		                                </table>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="panel-footer">
	                        	<a href="${pageContext.request.contextPath}/usersManagment/edit?id=${user.ID}">
	                            <button class="btn btn-sm btn-warning" type="button"
	                                    data-toggle="tooltip"
	                                    data-original-title="Edit this user"><i class="glyphicon glyphicon-edit"></i></button>
	                       		</a>
	                                    
	                 	        <a href="${pageContext.request.contextPath}/usersManagment/remove?id=${user.ID}">						
	                            <button class="btn btn-sm btn-danger" type="button"
	                                    data-toggle="tooltip"
	                                    data-original-title="Remove this user"><i class="glyphicon glyphicon-remove"></i></button>
	                         	</a>
		                    </div>
		                </div>
		            </div>
		        </div>
	        </c:forEach>
	   	</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    var panels = $('.user-infos');
		    var panelsButton = $('.dropdown-user');
		    panels.hide();
		
		    //Click dropdown
		    panelsButton.click(function() {
		        //get data-for attribute
		        var dataFor = $(this).attr('data-for');
		        var idFor = $(dataFor);
		
		        //current button
		        var currentButton = $(this);
		        idFor.slideToggle(400, function() {
		            //Completed slidetoggle
		            if(idFor.is(':visible'))
		            {
		                currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
		            }
		            else
		            {
		                currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
		            }
		        })
		    });
		
		
		    $('[data-toggle="tooltip"]').tooltip();
		
		    /* $('button').click(function(e) {
		        e.preventDefault();
		        alert("This is a demo.\n :-)");
		    });  */
		});
	</script>

</body>
</html>
