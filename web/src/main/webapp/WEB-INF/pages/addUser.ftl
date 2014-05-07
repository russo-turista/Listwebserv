<#include '/include/header.ftl'>
	<div class="container-fluid">
		<legend>Добавить пользователя</legend>
		<div class="col-lg-6 col-lg-offset-1">
			<form action="<@spring.url '/addUser'/>" class="form-horizontal"  method="POST" role="form"> 
				<div class="form-group">
					<label for="inputUserName" class="col-sm-5 control-label">Add user name:</label>
					<div class="col-sm-7">
						<@spring.formInput "user.name" 'class = "form-control"'/>
					</div>  
				</div>
				<div class="form-group">
					<label for="inputUserLogin" class="col-sm-5 control-label">Add user login:</label>
					<div class="col-sm-7">
						<@spring.formInput "user.login" 'class = "form-control"'/>
					</div>  
				</div>
				<div class="form-group">
					<label for="inputUserPassword" class="col-sm-5 control-label">Add user password:</label>
					<div class="col-sm-7">
						<@spring.formPasswordInput "user.password" 'class = "form-control"'/>
					</div>
				</div>
				<div class="form-group">
					<div class="checkbox">
						<label for="checkboxIsActiveUser" class="col-sm-5 control-label customCheckbox">Is active:</label>
						<div class="col-sm-7">
							<@spring.formCheckbox "user.active" "true"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="checkbox">
						<label for="checkboxIsUserAdmin" class="col-sm-5 control-label customCheckbox">Is admin:</label>
						<div class="col-sm-7">
							<@spring.formCheckbox "user.admin" "true"/>
						</div>
					</div>
				</div>
				<div class="col-sm-7 col-sm-offset-5">
					<button type="submit" class="btn btn-primary">Добавить</button>
				</div>
			</form>
	</div>  
<#include '/include/footer.ftl'>  