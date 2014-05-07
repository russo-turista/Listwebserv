<#include '/include/header.ftl'>




    <legend>Список серверов</legend>
    Current Date: ${currentDate}  
  
  <br/>
  <table class="table-bordered">
    <tr>
        <th>Host name </th>
        <th>Ip Address:Port</th>
        <th>Data last check</th>
        <th>Status active</th>
        <th>Редактировать/Удалить</th>
        
    </tr>
     <#list hostNameList as hostNameValue>
    <tr>
       <td>${hostNameValue.hostName}</td>
       <td>${hostNameValue.ipAddress}:${hostNameValue.hostPort}</td>
       <td>${hostNameValue.lastCheck}</td>
       <td>${hostNameValue.state}</td>
       <td>
       		<a href="<@spring.url '/editServer/${hostNameValue.idServer}' />">Изменить</a>
       		/
       		<a href="<@spring.url '/deleteServer/${hostNameValue.idServer}' />">Удалить</a>
       </td>
    </tr>
    </#list>           
  </table>
  <#include '/include/footer.ftl'> 