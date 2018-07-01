<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/index.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[type="submit"]')
				.click(
						function() {
							var json = {
								"username" : $('input[name="username"]').val(),
								"password" : $('input[name="password"]').val()
							};
							$
									.ajax({
										type : 'post',
										url : '${pageContext.request.contextPath}/login',
										data : JSON.stringify(json),
										contentType : 'application/json;charset=UTF-8',
										dataType : 'json',
										success : function(data) {
											if (data != null) {
												window.location
														.assign('${pageContext.request.contextPath}/jsp/main.jsp');
											}
										},
										error : function(html) {
											$('body').prepend('<span style="color:red;">用户名或密码错误</span>');
										}
									});
						});
	});
</script>
</head>
<body>
	用户名：
	<input name="username" type="text" />
	<br /> 密码：
	<input name="password" type="password" />
	<input type="submit" />
	<br />
	<a href="${pageContext.request.contextPath}/register.jsp">注册</a>
</body>
</html>