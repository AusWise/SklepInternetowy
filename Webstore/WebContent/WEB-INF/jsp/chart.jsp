<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript">
	    google.load('visualization', '1.0', {
	        'packages' : [ 'corechart' ]
	    });
    
    	google.setOnLoadCallback(drawChart);
 		
    	function myFunction(){
    		var month = document.getElementById("month").value;
		    var year = document.getElementById("rok").value;
	    	
		    var link="${pageContext.request.contextPath}/chart?";
		    
		    if(month!==null)
		    	link += "month=" + month + "&";
    		
		    if(year!==null)
		    	link += "year=" + year + "&";
		    
    		window.location.href = link;
    	}
    	
	    function drawChart() {
	    	//var month = document.getElementById("month");
		    //var year = document.getElementById("rok");
	    	
		    /*
	    	var data = [];
	    	
	    	data.push(['Product', 'Sprzedaz']);
	    	
	    	<c:forEach items="${entries}" var="entry">
	    			data.push([ '${entry.key}', ${entry.value} ]);	
	    	</c:forEach>
	    	
	    	data = google.visualization.arrayToDataTable(data);
	    	*/
	    	
	    	var data = google.visualization.arrayToDataTable([
	                                                              ['Product', 'Sprzedaz'],
	                                                              <c:forEach items="${entries}" var="entry">
	                                                                  [ '${entry.key}', ${entry.value} ],
	                                                              </c:forEach>
	                                                        ]);
	 		
	    	
	    	
	        var options = {
	            //'title' : 'Area-wise Top Seven Countries in the World',
	            is3D : true,
	            pieSliceText: 'label',
	            tooltip :  {showColorCode: true},
	            'width' : 1000,
	            'height' : 10000
	        };
	 
	        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
	        chart.draw(data, options);
	    }
	    
	</script>
</head>

<body>

	<jsp:include page="_menu.jsp" />

	<select id="month">
		<option value=""></option>
		<option value=0>Styczen</option>
		<option value=1>Luty</option>
		<option value=2>Marzec</option>
		<option value=3>Kwiecien</option>
		<option value=4>Maj</option>
		<option value=5>Czerwiec</option>
		<option value=6>Lipiec</option>
		<option value=7>Sierpien</option>
		<option value=8>Wrzesien</option>
		<option value=9>Pazdziernik</option>
		<option value=10>Listopad</option>
		<option value=11>Grudzien</option>
	</select>
	
	
	<select id="rok">
		<option value=""><option>
		<c:forEach items="${years}" var="year">
	   		<option> ${year} </opiton>
	    </c:forEach>
	</select>
	
	<button onclick="myFunction()">Click me</button>
	
    <div style="width: 600px;">
        <div id="chart_div"></div>
    </div>
    
</body>

</html>