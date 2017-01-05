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
<title>Поиск поставок</title>
</head>
<body>
	<div class="container-fluid" align="center">

		<h1>Поиск поставок</h1>

		<c:url var="searchUrl"
			value="/supplyController/search?idProvider=${idAttribute.provider.idProvider }" />
		<form:form class="form-horizontal" modelAttribute="idAttribute"
			method="POST" action="${searchUrl}">
			<table>
				<tr>
					<td><form:label path="provider.idProvider"></form:label></td>
					<td  style="display: none"><form:input path="provider.idProvider" /></td>
				</tr>

				<tr>
					<td><form:label path="carNumber">Номер автомобиля:</form:label></td>
					<td><form:input path="carNumber" class="form-control" /></td>
				</tr>

				<tr>
					<td><form:label path="department">Отдел:</form:label></td>
					<td><form:input path="department" class="form-control" /></td>
				</tr>

				<tr>
					<td><form:label path="arrivalDate">Дата прихода от:</form:label></td>
					<td><form:input type="date" path="arrivalDate"
							class="form-control" /></td>
				</tr>

				<tr>
					<td><form:label path="arrivalDate">Дата прихода до:</form:label></td>
					<td><form:input type="date" path="arrivalDate"
							class="form-control" /></td>
				</tr>
			</table>
			<br>
			<input value="Найти" input type="submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>