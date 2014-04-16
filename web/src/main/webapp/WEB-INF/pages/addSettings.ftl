<#include '/include/header.ftl'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head><title>List Hosts name</title>
<body>
<div id="header">

</div>
 

  <fieldset>
    <legend>Host Inf</legend>
  <form action="" method="POST">
  
 <table> 
  <table> 
  <tr>   
   <td> Интервал опроса серверов:  <@spring.formInput "config.timeRequest"/> <br/> </td>    
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
  </fieldset>
  <br/>
  
</div>  
</body>
</html>  