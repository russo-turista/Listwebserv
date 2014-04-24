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
  <form action="addServerToUser" method="POST">
  
  <table> 
  <tr>
   <td>
   <@spring.formCheckboxes "server.listServers", listServers, '<br>'/>
   </td>
   <td>
   <@spring.formCheckboxes "user.listUsers", listUsers, '<br>'/>
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