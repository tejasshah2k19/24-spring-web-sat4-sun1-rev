<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>

	<form action="saveuser2" method="post" enctype="multipart/form-data">

		FirstName : <input type="text" name="firstName" /><br>
		<br> Email :<input type="text" name="email" /><br>
		<br> Password : <input type="text" name="Password" /><br>
		<br> Profile : <input type="file" name="profile" /><br>
		<br> <input type="submit" value="Signup" />

	</form>

</body>
</html>