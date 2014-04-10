<#import "/spring.ftl" as spring />
<#import "formCheckbox.ftl" as formCheckbox />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head><title>List Hosts name</title>
<link rel="stylesheet" href="<@spring.url "/resources/style.css" /> type="text/css">
</head>
<body>
<div id="content">
   <@sec.authorize  access="isAuthenticated()">
            <p>Ваш логин: <@sec.authentication   property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="<@spring.url "/logout" />" role="button">Выйти</a></p>
 
        </@sec.authorize >  
                                                           