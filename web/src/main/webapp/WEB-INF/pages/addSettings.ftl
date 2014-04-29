<#include '/include/header.ftl'> 

  <legend>Настройки</legend>
  <form action="" method="POST">
  
 <table> 
  <table> 
  <tr>   
   <td> Интервал опроса серверов:  <@spring.formInput "config.timeRequest"/> <br/> </td>   
    <td> Вкл./Выкл. опрос серверов:  <@spring.formCheckbox "config.activeRuquest" "true"/> <br/> </td>  
  </tr>
  <tr>
   <td> Таймаут ожидания ответа сервера: <@spring.formInput "config.timeOutWaiting" /> <br/>  </td>
  </tr> 
  
   <tr>
  	<td> Интервал обновления страницы на стороне клиента: <@spring.formInput "config.timeUpdate" /> <br/> </td>
  </tr> 
  
   <tr>
    <td>  Адрес SMTP-сервера для отправки почтовых 
		сообщений: <@spring.formInput "config.addressSMTP" /> <br/>  </td>
  </tr> 
  <tr>
    <td>  Порт SMTP-сервера: <@spring.formInput "config.portSMTP" /> <br/>  </td>
  </tr>
   
 </table>         
 </table>
    <input type="submit" value="Send" />
  </form>
  <br/>
  
<#include '/include/footer.ftl'> 