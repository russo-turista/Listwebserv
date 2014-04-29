<#include '/include/header.ftl'>




    <legend>Список серверов</legend>
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
  <#include '/include/footer.ftl'> 