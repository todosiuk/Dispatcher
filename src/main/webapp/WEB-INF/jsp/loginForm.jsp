<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>Вход</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<c:if test="${not empty param.error}">
			<font color="red"> Ошибка входа :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
		</c:if>
		<form method="POST"
			action="<c:url value="/j_spring_security_check" />">
			<h2 class="form-signin-heading">Пожалуйста войдите</h2>
			<table>
				<tr>
					<td><input type="text" class="form-control"
						placeholder="Логин" name="j_username" /></td>
				</tr>
				<tr>
					<td><input type="password" class="form-control"
						placeholder="Пароль" name="j_password" /></td>
				</tr>
				<tr>
					<td class="checkbox" value="remember-me">Запомнить меня</td>
					<td><input type="checkbox" name="_spring_security_remember_me" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-primary"
						value="Войти" /> <input type="reset" class="btn btn-primary"
						value="Отмена" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>