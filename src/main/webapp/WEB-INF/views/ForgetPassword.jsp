<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">Forget Password</h2>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form action="forgetpassword" method="POST">


					<!-- Email Field -->
					<div class="form-group">
						<label for="email">Email address</label> <input type="email"
							class="form-control" value="${email}" id="email" name="email" required
							placeholder="Enter your email">
					</div>

				 
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary btn-block">Help!!</button>
				</form>
				<br> <a href="signup2">New User?</a> | <a href="login">Already Registered?</a>

				<br> <span class="text-danger">${error}</span>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>