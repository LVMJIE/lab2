<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
<title>BookList</title>
	<meta charset="utf-8"> 
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>



<div class="container">
	<h2>Information</h2>            
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Bookname</th>
				<th> Delete </th>
				<th> Update </th>
			</tr>
		</thead>
		<s:iterator value="aa" var="sx">
		<tbody>
			<tr>
				<td><a href="bookinformation.action?bookisbn=${sx.isbn}"><s:property value="title"/></td>
				<td><a href="Delete.action?bookisbn=${sx.isbn}">
						<p>
							<span class="glyphicon glyphicon-trash"></span>
						</p>
					</a>
				</td>
				<td><a href="ToUpdate.action?bookisbn=${sx.isbn}">
				<p>
					<span class="glyphicon glyphicon-folder-close"></span></p></a>
				</td>
			</tr>
		</tbody>
		</s:iterator>
	</table>
</div>



</body>
</html>