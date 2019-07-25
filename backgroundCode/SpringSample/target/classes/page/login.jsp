<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${base}/statistics/statistics" method="get" id="login-form" class="smart-form client-form" AutoComplete="off">
     <input type="text" id="userName" name="userName" class="userName" placeholder="用户名">
     <input type="password" id="password" name="password" class="password" placeholder="密码">
     <span id="error" style="color: red;"></span>
     <button type="submit">登    录</button>
</form>
    <input type="text" class="hidden" style="display:none;"
	value="<%=request.getSession().getAttribute("user")%>">
</body>
</html>