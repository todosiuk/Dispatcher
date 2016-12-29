<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Обновление поставщика</title>
</head>
<body>
<div class="container-fluid" align="center">
	<h1>Обновление данных поставщика</h1>
	<c:url var="saveUrl"
		value="update?idProvider=${providerAttribute.idProvider}" />
	<form:form class="form-horizontal" modelAttribute="providerAttribute" method="POST"
		action="${saveUrl}">
		<table>
			<tr>
				<td style="display: none"><form:label class="control-label" path="idProvider">Id:</form:label></td>
				<td style="display: none"><form:input path="idProvider" /></td>
			</tr>
			<tr>
				<td><form:label class="control-label" path="providerName">Название:</form:label></td>
				<td><form:input path="providerName" /></td>
			</tr>
		</table>
		<input type="submit" value="Сохранить" class="btn btn-primary" />
	</form:form>
</div>
</body>
</html>