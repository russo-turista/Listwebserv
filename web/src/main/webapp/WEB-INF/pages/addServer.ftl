<#import "spring.ftl" as spring />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head><title>List Hosts name</title>
<body>
<div id="header">

</div>
 
<div id="content">
     
  <fieldset>
    <legend>Host Inf</legend>
  <form action="addServer" method="POST">
  
  <table> 
  <tr>
   <td>
    Add address:  <@spring.formInput "server.hostName"/> <br/>
   </td>
  </tr> 
  <tr>
   <td>
    Add port: <@spring.formInput "server.hostPort" /> <br/>
   </td>
  </tr>
	<tr>
	<td>
  	 Add is active: <@spring.formCheckbox "server.active" "true"/> 
  	</td>
  </tr> 
   </table>
    <input type="submit" value="Send" />
  </form>
  </fieldset>
  <br/>
  
</div>  
</body>
</html>  