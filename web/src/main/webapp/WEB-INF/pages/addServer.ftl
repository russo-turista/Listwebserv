<#include '/include/header.ftl'> 
     
  <fieldset>
    <legend>Добавим сервер</legend>
  <form action="addServer" method="POST">
  
  <table> 
  <tr>
   <td>
    Add address:  <@spring.formInput "server.hostName"/> <br/>
   </td>
  </tr> 
  <tr>
   <td>
    Add port: <@spring.formInput "server.hostPort" /> <br/>
   </td>
  </tr>
  <tr>
  <td>
     Is active: <@spring.formCheckbox "server.active" "true"/> 
    </td>
  </tr> 
   </table>
    <input type="submit" value="Send" />
  </form>
  </fieldset>
  <br/>
  <#include '/include/footer.ftl'> 