<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[type="submit"]')
				.click(
						function() {
							var $json = {
								"username" : $('input[name="username"]').val(),
								"password" : $('input[name="password"]').val(),
								"email" : $('input[name="email"]').val(),
								"realname" : $('input[name="realname"]').val()
							};
							$
									.ajax({
										type : 'post',
										url : '${pageContext.request.contextPath}/register',
										data : JSON.stringify($json),
										contentType : 'application/json;charset=UTF-8',
										dataType : 'json',
										success : function(status) {
											window.location
													.assign('${pageContext.request.contextPath}/index.jsp')
										},
										error : function(html) {
											alert('异常' + html.status);
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
	<input name="password" type="text" />
	<br /> 邮件：
	<input name="email" type="text" />
	<br /> 真实姓名：
	<input name="realname" type="text" />
	<br />
	<input type="submit" />
</body>
</html>