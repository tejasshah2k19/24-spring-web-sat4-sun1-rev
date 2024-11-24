<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Input</h2>


<form action="addition" method="post"> 


	No.1 : <input type="text" name="n1"/>${result.getFieldError("n1").getDefaultMessage()}
	
	<br><br>
	No.2 : <input type="text" name="n2"/>${result.getFieldError("n2").getDefaultMessage()} <br> <br>
	
	Choice: <br>
		Add : <input type="radio" name="choice" value="add"><br>
		Sub : <input type="radio" name="choice" value="sub"><br>
		Mul : <input type="radio" name="choice" value="mul"><br>
		Div : <input type="radio" name="choice" value="div"><br>
		 
	
	<input type="submit" value="Addition"/> <br><br>

</form>

</body>
</html>