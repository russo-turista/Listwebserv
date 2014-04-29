<#import "/spring.ftl" as spring />
<#import "formCheckbox.ftl" as formCheckbox />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<head><title>List Hosts name</title>
		<link rel="stylesheet" href="<@spring.url"/resources/css/bootstrap.css"/>">
		<link rel="stylesheet" href="<@spring.url"/resources/css/custom.css"/>">
		<script src= "<@spring.url "/resources/js/jquery.js" />"> </script>
		<script src= "<@spring.url "/resources/js/bootstrap.js" />"> </script>
	</head>
	<body>
		<!-- "Header" -->
		<div class ="container-fluid header_context">
			<div class="row">
				<div class="col-lg-9 col-lg-offset-1">
					<div class="row header_titel">
						<h1>Система мониторинга веб-серверов</h1>
					</div>
					<div class="row">
		  				<div class="col-lg-12">
		  					<nav class="navbar navbar-default" role="navigation">
		  						<div class="container-fluid">
		  							<div class="navbar-header">
		                                <a class="navbar-brand" href="<@spring.url'/'/>">Main</a>
		                            </div>
		                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                                <ul class="nav navbar-nav">
		                                	<li class="active"><a href="<@spring.url '/addServer' />">Добавить сервер</a></li>
		                                    <li class=""><a href="<@spring.url '/listServers' />">Список серверов</a></li>
		                                    <li class=""><a href="<@spring.url '/addUser' />">Добавить пользователя</a></li>
		                                    <li><a href="<@spring.url '/listUsers'/>">Все пользователи</a></li>
		                                    <li><a href="<@spring.url '/addServerToUser'/>">SerToUser</a></li>
		                                    <li><a href="<@spring.url '/Settings'/>">Настройки</a></li>
		                                </ul>
		                            </div>
		  						</div>
		  					</nav>
		  				</div>
  					</div>
				</div>
				<div class="col-lg-2">
					<div class="row">
						<div class="col-lg-9 col-lg-offset-0">
							<div class="row">
		  						<div class="col-lg-12">
		  							<p>RU EN</p>
		  						</div>
  							</div>
  							<div class="row">
		  						<div class="col-lg-12">
					           		<p>Ваш логин: 
					           		<@sec.authorize  access="isAuthenticated()">
					           			<@sec.authentication   property="principal.username" /></p>	 
					        		</@sec.authorize >	
					        		<p><a class="btn btn-ms btn-danger" href="<@spring.url "/logout" />" 
					           			role="button">Выйти</a><p>
		  						</div>
		  					</div>
						</div>
					</div>
				</div>
  			</div>
  		</div>	
  		<!-- "Main context" -->
		<div class ="container-fluid">	
			<div class="col-lg-9 col-lg-offset-1">	