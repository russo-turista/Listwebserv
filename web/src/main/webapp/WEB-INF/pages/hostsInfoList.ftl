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
    <#list hostNameList  as hostName>
    <tr>
        <td>${hostName}</td>
    </tr>
    </#list>
     <tr>
        <th>Host information</th>
    </tr>
    <tr>
        <td> ${urlConnect} </td>
    </tr>
  </table>
 </fieldset>
</div>  
</body>
</html>  