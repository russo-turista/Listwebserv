<#include '/include/header.ftl'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head><title>List Hosts name</title>
<body>
<div id="header">

</div>
 
<div id="content">
     
  <fieldset>
    <legend>Host Inf</legend>
    Current Date: ${currentDate}  
  
  <br/>
  <table class="datatable">
    <tr>
        <th>Host Ip </th>
    </tr>
     <#list hostNameList as hostNameValue>
    <tr>
        <td>${hostNameValue.hostName}</td>
       <td>${hostNameValue.ipAddress}</td>
    </tr>
    </#list>           
  </table>
 </fieldset>
</div>  
</body>
</html>  