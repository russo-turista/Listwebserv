<#import "/spring.ftl" as spring />
<#import "formCheckbox.ftl" as formCheckbox />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<head><title>List Hosts name</title>
		<link rel="stylesheet" href="<@spring.url"/resources/css/bootstrap.css"/>">
		<link rel="stylesheet" href="<@spring.url"/resources/css/footer.css"/>">
		
        <script src= "<@spring.url "/resources/js/jquery.js" />"> </script>
		<script src= "<@spring.url "/resources/js/bootstrap.js" />"> </script>
	</head>
	<body>
		<div class ="container-fluid">
			<!--header-->
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
  						<div class="col-lg-7 col-lg-offset-2"><h1>Система опроса серверов</h1></div>
  						<div class="col-lg-3">
  							<div class="row">
  								<div class="col-lg-7 col-lg-offset-5">
  								
  									<div class="row">
		  								<div class="col-lg-12">
		  									<p>RU EN</p>
		  								</div>
  									</div>
  									
  									<div class="row">
		  								<div class="col-lg-12">
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
	  				<div class="row">
	  					<div class="col-lg-9 col-lg-offset-1">
 							<nav class="navbar navbar-default" role="navigation">
					  			<div class="container-fluid">
					  				<div class="navbar-header">
	                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                                    </button>
	                                    <a class="navbar-brand" href="#">Brand</a>
                                    </div>
                                   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                         <ul class="nav navbar-nav">
                                             <li class="active"><a href="#">Link</a></li>
                                             <li><a href="#">Link</a></li>
                                             <li class="dropdown">
                                                 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                                                 <ul class="dropdown-menu">
                                                      <li><a href="#">Action</a></li>
                                                      <li><a href="#">Another action</a></li>
                                                      <li><a href="#">Something else here</a></li>
                                                      <li class="divider"></li>
                                                      <li><a href="#">Separated link</a></li>
                                                      <li class="divider"></li>
                                                      <li><a href="#">One more separated link</a></li>
                                                 </ul>
                                            </li>
                                         </ul>
                                   </div>
					  			</div>
					  		</nav>
					  	</div>		
	  				</div>	
				</div>
			</div>
			<!--main context-->
			<div class="row">	
				<div class ="container-fluid">
				