<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>Список поставщиков</title>
</head>
<body>
	<a href="<c:url value="/logout" />">Выйти</a>
	<div class="container-fluid" align="center">
		<c:url var="addProvider" value="/providerController/providers/add" />
		<h3>
			<a href="${addProvider}" input type="submit" class="btn btn-primary" />Добавить
			поставщика</a>
		</h3>
		<p>
		<h1>Список поставщиков</h1>


		<table class="table">
			<thead style="background: #9AC0CD">
				<tr>
					<th>Название поставщика</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${providers}" var="provider">
					<c:url var="addSupply"
						value="/supplyController/add?idProvider=${provider.idProvider}" />
					<c:url var="editProvider"
						value="/providerController/providers/update?idProvider=${provider.idProvider}" />
					<c:url var="deleteProvider"
						value="/providerController/providers/delete?idProvider=${provider.idProvider}" />
					<c:url var="searchProviderByName"
						value="/providerController/providers/searchByName?name=${provider.providerName}" />
					<c:url var="showSearchForm"
						value="/supplyController/searchForm?idProvider=${provider.idProvider}" />
					<tr>
						<td><h3>
								<c:out value="${provider.providerName }" />
							</h3></td>

						<td><a href="${addSupply}" input type="submit"
							class="btn btn-primary">Добавить поставку</a></td>
						<td><a href="${showSearchForm }" input type="submit"
							class="btn btn-primary">Поиск поставок</a></td>
						<td><a href="${editProvider }" input type="submit"
							class="btn btn-primary">Редактировать поставщика</a></td>
						<td><a href="${deleteProvider }" input type="submit"
							class="btn btn-primary">Удалить поставщика</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>