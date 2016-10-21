
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<h2>Update book</h2>

<div style="padding: 100px 300px 5px;">
	<form action="UpdateBook.action" >
		<div class="input-group">
			<span class="input-group-addon">isbn</span>
			<input type="text" class="form-control" name="isbn" readonly="true" value="${oldBook.isbn}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">title</span>
			<input type="text" class="form-control" name="title" readonly="true" value="${oldBook.title}">			
		</div>
		<div class="input-group">
			<span class="input-group-addon">ID</span>
			<input type="text" class="form-control" name="bauthorid" readonly="true" value="${oldBook.authorid}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">publisher</span>
			<input type="text" class="form-control" name="publisher" valuer="${oldBook.publisher}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">DATE</span>
			<input type="text" class="form-control" name="publishdate" value="${oldBook.publishdate}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">$</span>
			<input type="text" class="form-control" name="price" value="${oldBook.price}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">ID</span>
			<input type="text" class="form-control" name="authorid"  value="${oldAuthor.authorid}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">name</span>
			<input type="text" class="form-control" name="name" value="${oldAuthor.name}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">age</span>
			<input type="text" class="form-control" name="age" value="${oldAuthor.age}">
		</div>
		<div class="input-group">
			<span class="input-group-addon">country</span>
			<input type="text" class="form-control" name="country" value="${oldAuthor.country}">
		</div>
        <input type="submit" value="提交"/>
     </form>
  </div>
</div>

<!-- 
Update Information
	
	        BookIsbn	   <s:textfield name="isbn"  value="%{oldBook.isbn}" readonly = "true"/>
	        BookTitle      <s:textfield name="title"  value="%{oldBook.title}" readonly = "true"/>
	        AuthorId       <s:textfield name="bauthorid"  value="%{oldBook.authorid}" readonly = "true"/>
            Publisher:     <s:textfield name="publisher" value = "%{oldBook.publisher}"/><br>
            PublishDate:   <s:textfield name="publishdate" value = "%{oldBook.publishdate}"/><br>
            Price          <s:textfield name="price" value = "%{oldBook.price}"/><br>
            <!-- AuthorID (PK), Name, Age, Country -
            authorId:      <s:textfield name="authorid" value = "%{oldAuthor.authorid}" /><br>
            author name:   <s:textfield name="name" value = "%{oldAuthor.name}"/><br>
            author age:    <s:textfield name="age" value = "%{oldAuthor.age}"/><br>
            autthorCountry:<s:textfield name="country" value = "%{oldAuthor.country}"/><br>
            <s:submit/>
        -->
</body>
</html>