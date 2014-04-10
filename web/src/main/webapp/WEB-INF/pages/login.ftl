<#import "spring.ftl" as spring />
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="width: 300px;">
    <form action="<@spring.url '/j_spring_security_check'/>" method="post">
        <h2>Please sign in</h2>      
        <input type="text" class="form-control" name="j_username" placeholder="login" required autofocus >
        <input type="password" class="form-control" name="j_password" placeholder="password" >
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
   
    </form>
</div>
</body>
</html>