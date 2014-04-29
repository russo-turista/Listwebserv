<#include '/include/header.ftl'>

  <legend>Добавим нового пользователя</legend>
  <form action="addUser" method="POST">
  
 <table> 
  <table> 
  <tr>   
   <td> Add user Name:  <@spring.formInput "user.name"/> <br/> </td>    
  </tr>
   
  <tr>
   <td> Add user Login: <@spring.formInput "user.login" /> <br/>  </td>
  </tr> 
  
   <tr>
  	<td> Add user Password: <@spring.formPasswordInput "user.password" /> <br/> </td>
  </tr> 
  
   <tr>
    <td>  Add user Email: <@spring.formInput "user.email" /> <br/>  </td>
  </tr> 
  
   <tr>
    <td>   
    	 Add is active: <@spring.formCheckbox "user.active" "true"/> </td>
  </tr> 
  
  <tr>
   <td>   Add is admin: <@spring.formCheckbox "user.admin" "true"/> </td>
  </tr>
 </table>         
 </table>
    <input type="submit" value="Send" />
  </form>
  </fieldset>
  <br/>
<#include '/include/footer.ftl'>  