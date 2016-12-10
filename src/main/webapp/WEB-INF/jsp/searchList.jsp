<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Список поставок</title>
</head>
<body>
	<a href="<c:url value="/logout" />">Выйти</a>
	<div class="container-fluid" align="center">
		<h1>Список поставок</h1>
		<table class="table">
			<thead style="background: #9AC0CD">
				<th>Дата поставки</th>
				<th>Номер автомобиля</th>
				<th>Фамилия водителя</th>
				<th>Телефон</th>
				<th>Отдел</th>
				<th>Товар</th>
				<th>Документ поставщика</th>
				<th>Документ получателя</th>
				<th>Кладовщик</th>
				<th>Диспетчер</th>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="list">
					<tr>
						<td><c:out value="${list.arrivalDate }" /></td>



					</tr>



				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>