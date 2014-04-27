<#include '/include/header.ftl'>
 
     
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