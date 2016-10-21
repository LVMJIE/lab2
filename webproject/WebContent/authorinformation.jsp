<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:iterator value="aa" var="sx">
<s:property value="isbn" />|
<s:property value="title" />
<s:property value="authorid" />|
<s:property value="publisher" />|
<s:property value="publishdate" />|
<s:property value="price" />|<br>
</s:iterator>
</body>
</html>