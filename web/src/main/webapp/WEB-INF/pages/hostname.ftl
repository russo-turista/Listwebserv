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
  <form action="hostsInfoList" method="POST">
  
  <table> 
  <tr>
   <th>
    Add address:  <@spring.formInput "servers.hostName"/> <br/>
   </th>
   <th>
    Add port: <@spring.formInput "servers.hostPort" /> <br/>
   </th>
    </tr>
   </table>
    <input type="submit" value="Send" />
  </form>
  </fieldset>
  <br/>
  
</div>  
</body>
</html>  