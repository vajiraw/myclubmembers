<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<html>
<body>

	<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
/* district change on fire this*/
    function myFunc() {
    	  var  selectedValue = $("#dselect").val();
    	/*    alert(selectedValue); */
    	$.ajax({
    		type : "POST",
    		data: {val: selectedValue},
            url : '/members/getElectorates',
            success : function(data) {
                $('#eselect').empty(); // empty existing list
                var options = '';                
                 $.each(data, function(index, item) { 
                    $("#eselect").append($('<option>').text(item.electorateName).attr('value',item.id)); 
                }); 
            }
        });
    }
    function electorate() {
    	/* Electorate change on fire this*/
    	var  selectedElec = $("#eselect").val();
    	$.ajax({
    		type : "POST",
    		data: {val: selectedElec},
            url : '/members/getDSs',
            success : function(data) {
            	alert("success "+selectedElec);
                $('#pselect').empty(); // empty existing list
                var options = '';                
                 $.each(data, function(index, item) { 
                    $("#pselect").append($('<option>').text(item.name).attr('value',item.id)); 
                }); 
            }
        });
  }
function divisionalSec() {
	/* Division sec change on fire fills locals select this*/
		alert("divitional secs ");
    	var  selectedDivs = $("#pselect").val();
    	$.ajax({
    		type : "POST",
    		data: {val: selectedDivs},
            url : '/members/getLocals',
            success : function(data) {
            	alert("success "+selectedDivs);
                $('#localSelect').empty(); // empty existing list
                var options = '';                
                 $.each(data, function(index, item) { 
                    $("#localSelect").append($('<option>').text(item.name).attr('value',item.id)); 
                }); 
            }
        });
    	
  }
  function localGov() {
		/* local gov change on fire fills  select this*/	
  	var  localGov = $("#localSelect").val();
  	$.ajax({
  		type : "POST",
  		data: {val: localGov},
          url : '/members/getGramas',
          success : function(data) {
          	alert("success "+localGov);
              $('#gramaSelect').empty(); // empty existing list
              var options = '';                
               $.each(data, function(index, item) { 
            	   alert("success "+item.name);
                  $("#gramaSelect").append($('<option>').text(item.name).attr('value',item.id)); 
              }); }
      });}
  	function grams() {
		/* local gov change on fire fills  select this*/		
  	var  gramasewa = $("#gramaSelect").val();
  	$.ajax({
  		type : "POST",
  		data: {val: gramasewa},
          url : '/members/getPollingCenter',
          success : function(data) {
          	alert("success "+gramasewa);
              $('#pollingsSelect').empty(); // empty existing list
              var options = '';                
               $.each(data, function(index, item) { 
            	   alert("success "+item.name);
                   $("#pollingsSelect").append($('<option>').text(item.pollingCenterName).attr('value',item.id));  
              }); 
          }
      });
	}
  	
  	function members() {
		/* local polling centers  change on fire fills  select this*/		
  	var  pollscenter = $("#pollingsSelect").val();
  	$.ajax({
  		type : "POST",
  		data: {val: pollscenter},
          url : '/members/xxxxxx',
          success : function(data) {
          	alert("success "+pollscenter);
          	// change following to cater changes
              $('#pollingsSelect').empty(); // empty existing list
              var options = '';                
               $.each(data, function(index, item) { 
            	   alert("success "+item.name);
                   $("#pollingsSelect").append($('<option>').text(item.pollingCenterName).attr('value',item.id));  
              }); 
          }
      });
}
  
</script>
	<h1>Party Members List</h1>
	<table border="2" width="70%" cellpadding="2">
	
			<tr>         
			<%-- <td>District</td>   
			<td><form:select path="districts">
					<form:option value="default-value" label="--Please Select" />
					<form:options items="${districts}" itemValue="id" itemLabel="districtName" onchange="myFunc()" />
				</form:select>
			</td> --%>
               <td>District</td> 
                <td><form:select value="default-value" label="--Please Select" id="dselect" name="selectCountry" path="districts" items="${districts}" itemValue="id" itemLabel="districtName" onchange="myFunc()" /></td>
                <td><form:errors path="districts" cssClass="error" /></td>
            </tr>
            <tr>         
			<td>Ele</td>       
                <td><form:select id="eselect" name="selectElectorate" path="eletorates" items="${eletorates}"  itemValue="id" itemLabel="districtName" onchange="electorate()" /></td>
                <td><form:errors path="districts" cssClass="error" /></td>
            </tr>
            
            <tr>         
			<td>PSecretary</td>       
                <td><form:select id="pselect" name="selectDivision" path="divisions" items="${divisions}"  itemValue="id" itemLabel="localName"  onchange="divisionalSec()" /></td>
                <td><form:errors path="districts" cssClass="error" /></td>
            </tr>
            
            <tr> 
            	<td>Local Govs</td>               
                <td><form:select id="localSelect" name="selectdivision" path="locals" items="${locals}" itemValue="id" itemLabel="name" onchange="localGov()"/></td>
                <td><form:errors path="districts" cssClass="error" /></td>
            </tr>
            
            <tr> 
            	<td>Grama Sewa  Wasam</td>               
                <td><form:select id="gramaSelect"                     path="gramasewas" items="${gramasewas}" itemValue="id" itemLabel="name" onchange="grams()"/></td>
                <td><form:errors path="districts" cssClass="error" /></td>
            </tr>
            
            <tr> 
            	<td>Polling Center </td>               
                <td><form:select id="pollingsSelect"                     path="pollingCenter" items="${pollingCenter}" itemValue="id" itemLabel="name" onchange="members()"/></td>
                <td><form:errors path="districts" cssClass="error" /></td>
            </tr>


</body>
</html>