<#include '/include/header.ftl'> 
	<div class="container-fluid">
		<div class="col-lg-3 col-lg-offset-4">
		    <form action="<@spring.url '/j_spring_security_check'/>" method="post">
		        <h3>Please sign in</h3>     	        
		        <div class="form-group">
	   				<label for="inputLogin">Login:</label>
	    			<input type="text" class="form-control" name="j_username" placeholder="Ener login" required autofocus>
	  			</div>
	  			<div class="form-group">
	    			<label for="inputPassword">Password</label>
	    			<input type="password" class="form-control"  name="j_password" placeholder="Password" >
	  			</div>
		   		<button type="submit" class="btn btn-primary">Submit</button>
		    </form>
		</div>    
	</div>
<#include '/include/footer.ftl'> 