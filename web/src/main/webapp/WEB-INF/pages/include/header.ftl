<#import "/spring.ftl" as spring />
<#import "formCheckbox.ftl" as formCheckbox />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<head><title>List Hosts name</title>
		<link rel="stylesheet" href="<@spring.url"/resources/css/bootstrap.css"/>">
		<script src= "<@spring.url "/resources/js/bootstrap.js" />"> </script>
	</head>
	<body>
		<div class ="container-fluid">
			<div class="row-fluid">
  				<div class="span12">
  					<div class="row-fluid">
  						<div class="span7 offset2"><h1>Система опроса серверов</h1></div>
  						<div class="span3">
  							<div class="row-fluid">
  								<div class="span7 offset5">
  									<div class="row-fluid"><div class="span12"></div></div>
  									<div class="row-fluid">
		  								<div class="span12">
		  									<p>RU EN</p>
		  								</div>
  									</div>
		  							<div class="row-fluid">
		  								<div class="span12">
		  									<@sec.authorize  access="isAuthenticated()">
					           				 	<p>Ваш логин: <@sec.authentication   property="principal.username" /></p>	 
					        				</@sec.authorize >	
					        				<p><a class="btn btn-lg btn-danger" href="<@spring.url "/logout" />" 
					           				 		role="button">Выйти</a><p>
		  								</div>
		  							</div>	
  								</div>
	  					</div>		
  					</div>	
 				</div>
 			</div>	
 			<div class="row-fluid">	
 				<div class="span9 offset1">
 					<div class="navbar">
					  <div class="navbar-inner">
					    <div class="container">
					 
					      <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
					      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					      </a>
					 
					      <!-- Be sure to leave the brand out there if you want it shown -->
					      <a class="brand" href="#">Project name</a>
					 
					      <!-- Everything you want hidden at 940px or less, place within here -->
					      <div class="nav-collapse">
					        <!-- .nav, .navbar-search, .navbar-form, etc -->
					      </div>
					 
					    </div>
					  </div>
					</div>
 				</div>
			</div>  
		</div>                                          