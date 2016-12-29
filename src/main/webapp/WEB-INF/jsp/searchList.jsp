<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Список поставок</title>
</head>
<body>
	<a href="<c:url value="/logout" />">Выйти</a>

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
			<c:forEach items="${supplyList}" var="searchList">
				<tr>
					<td><c:out value="${searchList.arrivalDate }" /></td>
					<td><c:out value="${searchList.carNumber }" /></td>
					<td><c:out value="${searchList.driverName }" /></td>
					<td><c:out value="${searchList.phone }" /></td>
					<td><c:out value="${searchList.department }" /></td>
					<td><c:out value="${searchList.product }" /></td>
					<td><c:out value="${searchList.vendorDocument}" /></td>
					<td><c:out value="${searchList.documentReceiving}" /></td>
					<td><c:out value="${searchList.storekeeper}" /></td>
					<td><c:out value="${searchList.dispatcher}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>