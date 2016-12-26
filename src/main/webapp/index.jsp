<!-- 
<html>
<body>
<h2>Hello World!</h2>
</body>
</html>

 -->

<html>
<body>
	<h2>登录</h2>
	<form method="post"
		action="<%=request.getContextPath() %>/user.do?method=login">
		email:<input type="text" name="email" id="email"><br /> <input
			type="submit" value="login">
	</form>
</body>
</html>


