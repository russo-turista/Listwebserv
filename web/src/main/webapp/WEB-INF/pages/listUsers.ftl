<#include '/include/header.ftl'>
    <legend>Список пользователей</legend>  
  
  <div class="container-fluid"> 
    <div class="col-lg-3">
      <table class="datatable">
          <tr>
          </tr>
            <#list listUsers as listUsersValue>
              <tr>
                  <td><a  href="<@spring.url '/user/${listUsersValue.userId}' />" >${listUsersValue.name}</a></td>  
              </tr>
            </#list>           
        </table>
    </div>  
  </div>  
<#include '/include/footer.ftl'> 