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
    </tr>
     <#list listUsers as listUsersValue>
    <tr>
         <td><a  href="<@spring.url '/user/${listUsersValue.userId}' />" >${listUsersValue.name}</a></td>  
    </tr>
    </#list>           
  </table>
 </fieldset>
</div>  
</body>
</html>  