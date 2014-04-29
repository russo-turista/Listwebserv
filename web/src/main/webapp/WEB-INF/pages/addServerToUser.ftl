<#include '/include/header.ftl'> 
     
  
  <legend>Распределение серверов по пользователям</legend>
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
  
  <br/>
<#include '/include/footer.ftl'> 