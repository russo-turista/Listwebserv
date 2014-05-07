<#include '/include/header.ftl'> 

<div class="container-fluid">
	<legend>Настройки</legend>
	<form action="<@spring.url '/Settings'/>" class="form-horizontal"  method="POST" role="form"> 
    	<div class="col-lg-8 col-lg-offset-0">
        	<div class="form-group">
            	<label for="inputTimeRequest" class="col-sm-8 control-label">Интервал опроса серверов:</label>
            	<div class="col-sm-4">
              		<@spring.formInput "config.timeRequest" 'class = "form-control"'/>    
            	</div>      
            </div>  
            <div class="form-group">
            	<label for="inputTimeOutWaiting" class="col-sm-8 control-label">Таймаут ожидания ответа сервера:</label>
            	<div class="col-sm-4">
                	<@spring.formInput "config.timeOutWaiting" 'class = "form-control"'/>    
            	</div>      
            </div>
            <div class="form-group">
            	<label for="inputTimeOutWaiting" class="col-sm-8 control-label">Интервал обновления страницы на стороне клиента</label>
            	<div class="col-sm-4">
              		<@spring.formInput "config.timeUpdate" 'class = "form-control"'/>    
            	</div>      
            </div>
            <div class="form-group">
            	<label for="inputAddressSMTP" class="col-sm-8 control-label">Адрес SMTP-сервера для отправки почтовых 
		сообщений:</label>
            	<div class="col-sm-4">
              		<@spring.formInput "config.addressSMTP" 'class = "form-control"'/>    
            	</div>      
            </div>
            <div class="form-group">
            	<label for="inputAddressSMTP" class="col-sm-8 control-label">Порт SMTP-сервера:</label>
            	<div class="col-sm-4">
              		<@spring.formInput "config.portSMTP" 'class = "form-control"'/>    
            	</div>      
            </div>
          <div class="col-sm-8 col-sm-offset-6" >      
            <button type="submit" class="btn btn-primary">Добавить</button>
          </div>        
		</div>
	    <div class="col-lg-4 col-lg-offset-0">
            <div class="form-group">
	            <div class="checkbox">
	              <label for="checkboxActive" class="col-sm-8 control-label customCheckbox">Вкл./Выкл. опрос серверов:</label>
	              <div class="col-sm-1">
	                <@spring.formCheckbox "config.isActiveRuquest" "true"/> 
	              </div>
	            </div>  
          	</div>  	
	  	</div>
	</form>	        
  </div>  
  
<#include '/include/footer.ftl'> 