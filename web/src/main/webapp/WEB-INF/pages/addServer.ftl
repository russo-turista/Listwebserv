<#include '/include/header.ftl'> 
 
	<div class="container-fluid">
	    <legend>Добавим сервер</legend>
	    <div class="col-lg-6 col-lg-offset-1">
	        <form action="<@spring.url '/addServer'/> <@m.isCreate/>" class="form-horizontal"  method="POST" role="form"> 
	        	<div class="form-group">
	            	<label for="inputhostName" class="col-sm-5 control-label">Add address:</label>
	            	<div class="col-sm-7">
	            		<@spring.formInput "server.hostName" 'class = "form-control"'/>    
	            	</div>      
	        	</div>  
	          <div class="form-group">
	            <label for="inputhostPort" class="col-sm-5 control-label"> Add port:</label>
	            <div class="col-sm-7">
	              <@spring.formInput "server.hostPort" 'class = "form-control"'/>
	            </div>
	          </div>
	          <div class="form-group">
	            <label for="inputurlPath" class="col-sm-5 control-label">Url: </label>
	            <div class="col-sm-7">
	              <@spring.formInput "server.urlPath" 'class = "form-control"'/>
	            </div>
	          </div>  
	          <div class="form-group">
	            <div class="checkbox">
	              <label for="checkboxActive" class="col-sm-5 control-label customCheckbox">Is active:</label>
	              <div class="col-sm-7">
	                <@spring.formCheckbox "server.active" "true"/> 
	              </div>
	            </div>  
	          </div> 
	          <div class="col-sm-7 col-sm-offset-5" >      
	            <button type="submit" class="btn btn-primary">
	            	<#if isCreate >
    <					Добавить
					<#else>
						Изменить
					</#if>	
	             Добавить
	            
	            </button>
	          </div>        
	        </form>
	    </div>    
	</div>  
<#include '/include/footer.ftl'> 