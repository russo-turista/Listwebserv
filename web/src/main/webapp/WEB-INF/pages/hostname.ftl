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
  <form name="hostName" action="addHostName.html" method="post">
  <table> 
  <tr>
   <th>
    Add address: <input type="text" name="hostName" /> <br/>
   </th>
   <th>
    Add port: <input type="text" name="hostPort" /> <br/>
   </th>
    </tr>
   </table>
    <input type="submit" value="   Send   " />
  </form>
  </fieldset>
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
 
</div>  
</body>
</html>  