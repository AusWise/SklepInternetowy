<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title><spring:message code="page.account.title"/></title>
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
.toppad
{margin-top:20px;
}

    </style>
    <!-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script> -->
</head>
<body>

<jsp:include page="_menu.jsp" />


<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
           <!-- <A href="edit.html" >Edit Profile</A>

        <A href="edit.html" >Logout</A> -->
       <br>
<!-- <p class=" text-info">May 05,2014,03:00 pm </p> -->
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${user.imie} ${user.nazwisko}</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                
                <!--<div class="col-xs-10 col-sm-10 hidden-md hidden-lg"> <br>
                  <dl>
                    <dt>DEPARTMENT:</dt>
                    <dd>Administrator</dd>
                    <dt>HIRE DATE</dt>
                    <dd>11/12/2013</dd>
                    <dt>DATE OF BIRTH</dt>
                       <dd>11/12/2013</dd>
                    <dt>GENDER</dt>
                    <dd>Male</dd>
                  </dl>
                </div>-->
                <div class=" col-md-9 col-lg-9 "> 
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

					<c:if test="${pageContext.request.isUserInRole('EMPLOYEE') || pageContext.request.isUserInRole('ADMIN')}">
						<a href="${pageContext.request.contextPath}/productsManagment" class="btn btn-primary"><spring:message code="page.account.productsManagment"/></a>
					</c:if>
					
					<c:if test="${pageContext.request.isUserInRole('ADMIN')}">
						<a href="${pageContext.request.contextPath}/usersManagment" class="btn btn-primary"><spring:message code="page.account.accountsManagment"/></a>
					</c:if>
                  
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <!-- <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>  -->
                        <a href="${pageContext.request.contextPath}/account/edit" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                        <span class="pull-right">
                            
                            <!-- <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a> -->
                        </span>
                    </div>
            
          </div>
        </div>
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

    $('button').click(function(e) {
        e.preventDefault();
        alert("This is a demo.\n :-)");
    });
});
</script>
</body>
</html>