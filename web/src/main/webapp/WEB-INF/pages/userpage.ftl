<#include '/include/header.ftl'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head><title>List Hosts name</title>
<body>
<div id="header">

</div>
 
<div id="content">
     
  <fieldset>
    <legend>List User</legend>
    
  
  <br/>
  <table class="datatable">
  	<tr>
  		<td>
		  <tr>   
		   <td> user Name:  ${user.name} </td>    
		  </tr>
   
		  <tr>
		   <td> user Login:  ${user.login}   </td>
		  </tr> 
  
		   <tr>
		    <td> user Email: ${user.email}  </td>
		   </tr> 
  
		   <tr>
		    <td> is active: ${user.active?string('yes', 'no')}</td>
		   </tr> 
  
		   <tr>
		    <td>   is admin: ${user.admin?string('yes', 'no')}</td>
		   </tr>
  		</td>
  		<td>
     	<#list userServerList as server>
    		<tr>
        		<td>${server.hostName}</td> 
        		<td>${server.state}</td> 
    		</tr>
     	</#list> 
  		</td>        
  	</tr>  
  </table>
 </fieldset>
</div>  
</body>
</html>  