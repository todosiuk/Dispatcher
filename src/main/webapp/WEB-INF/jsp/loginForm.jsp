<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="container-fluid" align="center">
		<h3>Login with Username and Password</h3>
		<c:url var="loginUrl" value="/login"></c:url>
		<form action="${loginUrl}" method="POST">
			<table>
				<tr>
					<td>User ID:</td>
					<td><input type='text' class="form-control" name='username' /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' class="form-control"
						name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" class="btn btn-primary"
						type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>