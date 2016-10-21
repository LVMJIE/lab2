<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<head>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <script> 
      //同步函数 
      function synchronize(){ 
        document.getElementById('i1').value =document.getElementById('i2').value; 
        //alert("同步成功"); 
     } 
      //执行同步 
      setInterval(synchronize,5);//同步的时间间隔，每0.5秒同步一次 
      
      </script> 
<body>
<div class="container">
	<h2>ADD book</h2>

<div style="padding: 100px 300px 5px;">
	<s:form action="AddBook.action" >
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="isbn" placeholder="BookIsbn">
		</div>
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="title" placeholder="Title">			
		</div>
		<div class="input-group">
			<span class="input-group-addon">@</span>
			<input type="text" class="form-control" name="bauthorid" id="i2" placeholder="Author ID">
		</div>
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="publisher" placeholder="Publisher">
		</div>
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="publishdate" placeholder="Publish Date">
		</div>
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="price" placeholder="Price">
		</div>
		<div class="input-group">
			<span class="input-group-addon">@</span>
			<input type="text" class="form-control" name="authorid" id="i1" readonly="true" placeholder="Author ID (same to abow)">
		</div>
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="name" placeholder="Name">
		</div>
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="age" placeholder="Age">
		</div>
		<div class="input-group">
			<span class="input-group-addon">#</span>
			<input type="text" class="form-control" name="country" placeholder="Country">
		</div>
	<!--  	
		</div>
	        BookIsbn	   <s:textfield name="isbn" />
	        BookTitle      <s:textfield name="title"/>
	        AuthorId       <s:textfield name="bauthorid" id="i2" />
            Publisher:     <s:textfield name="publisher"/><br>
            PublishDate:   <s:textfield name="publishdate"/><br>
            Price          <s:textfield name="price"/><br>
            <!-- AuthorID (PK), Name, Age, Country 
            authorId:      <s:textfield name="authorid" id="i1"/><br>
            author name:   <s:textfield name="name"/><br>
            author age:    <s:textfield name="age"/><br>
            autthorCountry:<s:textfield name="country"/><br>-->	
            <s:submit />
        </s:form>
        </div>
        </div>
</body>
</html>