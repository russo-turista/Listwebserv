<#include '/include/header.ftl'>
 <legend>${user.name}</legend>    
<div class="container-fluid"> 
    <div class="col-lg-3">
      <table  class="table table-condensed">
      	<tr>
      		<td>
    		  <tr>   
    		   <td> user Name:  ${user.name} </td>    
    		  </tr>
       
    		  <tr>
    		   <td> user Login:  ${user.login}   </td>
    		  </tr> 
      
    		   <tr>
    		    <td> user Email: ${user.email}  </td>
    		   </tr> 
      
    		   <tr>
    		    <td> is active: ${user.active?string('yes', 'no')}</td>
    		   </tr> 
      
    		   <tr>
    		    <td>   is admin: ${user.admin?string('yes', 'no')}</td>
    		   </tr>
      		</td>
      		<td>
         	<#list userServerList as server>
        		<tr>
            		<td>${server.hostName}</td> 
            		<td>${server.state}</td> 
        		</tr>
         	</#list> 
      		</td>        
      	</tr>  
      </table>
      
  </div>    
</div>
<#include '/include/footer.ftl'> 