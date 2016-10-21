<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<head>
<meta charset="utf-8"> 
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>



<div class="container">
	<h2>Information</h2>            
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Book ISBN</th>
				<th> Title </th>
				<th> Authorid </th>
				<th>Publisher</th>
				<th> Publish Date </th>
				<th> Price </th>
			</tr>
		</thead>
		<s:iterator value="aa" var="sx">
		<tbody>
			<tr>
				<td><s:property value="isbn" /></td>
				<td><s:property value="title" /></td>
				<td><s:property value="authorid" /></td>
				<td><s:property value="publisher" /></td>
				<td><s:property value="publishdate" /></td>
				<td><s:property value="price" /></td>
			</tr>
		</tbody>
		<thead>
			<tr>
				<th>Author ID</th>
				<th> Name </th>
				<th> Age </th>
				<th>Country</th>
			</tr>
		</thead>
		</s:iterator>
		<s:iterator value="bb" var="bx">
		<tbody>
			<tr>
				<td><s:property value="authorid" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="age" /></td>
				<td><s:property value="country" /></td>
				
			</tr>
		</tbody>
		</s:iterator>
	</table>
</div>
<!-- 
<s:iterator value="aa" var="sx">
<s:property value="isbn" />|
<s:property value="title" />
<s:property value="authorid" />|
<s:property value="publisher" />|
<s:property value="publishdate" />|
<s:property value="price" />|
</s:iterator>

<s:iterator value="bb" var="bx">
<s:property value="authorid" />|
<s:property value="name" />|
<s:property value="age" />|
<s:property value="country" />
</s:iterator>
 -->
</body>
</html>