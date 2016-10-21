<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<head>


 <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StartPage</title>
    <style>
#login_click{ margin-top:32px; height:100px;}  
#login_click a  
{  
    text-decoration:none;  
    background:#2f435e;  
    color:#f2f2f2;  
      
    padding: 100px 100px 100px 100px;  
    font-size:50px;  
    font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;  
    font-weight:bold;  
    border-radius:3px;  
      
    -webkit-transition:all linear 0.30s;  
    -moz-transition:all linear 0.30s;  
    transition:all linear 0.30s;  
      
    }  
   #login_click a:hover { background:#385f9e; }  

#login_click2{ margin-top:32px; height:100px;}  
#login_click2 a 
{  
    text-decoration:none;  
    background:#2f435e;  
    color:#f2f2f2;  
      
    padding: 100px 80px 100px 80px;  
    font-size:50px;  
    font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;  
    font-weight:bold;  
    border-radius:3px;  
      
    -webkit-transition:all linear 0.30s;  
    -moz-transition:all linear 0.30s;  
    transition:all linear 0.30s;  
      
    }  
   #login_click2 a:hover { background:#385f9e; }  
   </style>
   



</head>
<body>


	<p style="font-family:verdana;font-size:80%;color:green">
<TT>Welcome To My Library</TT>
</p>
	<form method=get action="toBook"> 
		<ul style="position:absolute; top:150px; left:250px">
        	<div id="login_click">  
        		<a id="btlogin" href="book.jsp">toBook</a>  
        	</div>    
    	</ul>
    </form>

    <form method=get action="toAuthor"> 
        <ul style="position:absolute; top:150px; left:650px">
        	<div id="login_click2">  
        		<a id="btlogin" href="author.jsp">toAuthor</a>  
    		</div>    
    	</ul>
    </form>
	
</body>
</html>