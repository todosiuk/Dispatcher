<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Добавление поставки</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<h1>Добавление новой поставки</h1>
		<c:url var="saveUrl"
			value="/supplyController/add?idProvider=${supplyAttribute.provider.idProvider }" />
		<form:form class="form-horizontal" modelAttribute="supplyAttribute"
			method="POST" action="${saveUrl}">
			<table>
				<tr>
					<td><form:label class="control-label"
							path="provider.idProvider"></form:label></td>
					<td style="display: none"><form:input
							path="provider.idProvider" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="carNumber">Номер автомобиля:</form:label></td>
					<td><form:input path="carNumber" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="driverName">Фамилия водителя:</form:label></td>
					<td><form:input path="driverName" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="phone">Телефон:</form:label></td>
					<td><form:input path="phone" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="department">Отдел:</form:label></td>
					<td><form:input path="department" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="product">Товар:</form:label></td>
					<td><form:input path="product" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="vendorDocument">Документ поставщика:</form:label></td>
					<td><form:input path="vendorDocument" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="documentReceiving">Документ получателя:</form:label></td>
					<td><form:input path="documentReceiving" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="storekeeper">Кладовщик:</form:label></td>
					<td><form:input path="storekeeper" /></td>
				</tr>

				<tr>
					<td><form:label class="control-label" path="dispatcher">Диспетчер:</form:label></td>
					<td><form:input path="dispatcher" /></td>
				</tr>

			</table>
			<br>
			<input value="Сохранить" input type="submit" class="btn btn-primary" />
		</form:form>
</body>
</html>