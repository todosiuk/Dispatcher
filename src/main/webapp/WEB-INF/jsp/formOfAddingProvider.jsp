<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Добавление поставщика</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<h1>Создание нового поставщика</h1>
		<c:url var="saveUrl" value="/providerController/providers/add" />
		<form:form modelAttribute="providerAttribute" method="POST"
			action="${saveUrl}">
			<table>
				<tr>
					<td><form:label class="col-sm-2 control-label" path="providerName">Поставщик:</form:label></td>
					<td><form:input class="form-control"
							placeholder="Введите название поставщика" path="providerName" /></td>
				</tr>
			</table>
			<br>
			<input type="submit" class="btn btn-primary" value="Сохранить" />
		</form:form>
</body>
</html>