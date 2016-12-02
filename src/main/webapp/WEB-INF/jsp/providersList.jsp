<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Список поставщиков</title>
</head>
<body>
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
			<tbody style="background: #BFEFFF">
				<c:forEach items="${providers}" var="provider">
					<c:url var="addSupply"
						value="/supplyController/add?id=${provider.idProvider}" />
					<c:url var="editProvider"
						value="/providerController/providers/update?id=${provider.idProvider}" />
					<c:url var="deleteProvider"
						value="/providerController/providers/delete?id=${provider.idProvider}" />
					<c:url var="searchProviderByName"
						value="/providerController/providers/searchByName?name=${provider.providerName}" />
					<tr>
						<td><a href="searchSupply"><c:out
									value="${provider.providerName }" /> </a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>

</body>
</html>