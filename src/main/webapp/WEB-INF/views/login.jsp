<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V3</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Custom jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/images/nticxs-logo.png" />'>
	<link href='<c:url value="/resources/nuevo/vendor/bootstrap/css/bootstrap.min.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/fonts/iconic/css/material-design-iconic-font.min.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/vendor/animate/animate.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/vendor/css-hamburgers/hamburgers.min.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/vendor/animsition/css/animsition.min.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/vendor/select2/select2.min.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/vendor/daterangepicker/daterangepicker.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/css/util.css" />' rel="stylesheet">
	<link href='<c:url value="/resources/nuevo/css/main.css" />' rel="stylesheet">
	
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('resources/images/casa.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						Log in
					</span>
                    <c:if test="${not empty msg1}">
                        <div class="alert alert-warning">
                        	${msg1}
                    	</div>
                    </c:if>

                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Invalid user name and password.</p>
                        </div>
                    </c:if>
                    
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    
                    <c:if test="${not empty msg2}">
                        <div class="alert alert-success" id="msg2Div">
                        	${msg2}
                    	</div>
                    </c:if>
                    
                    <c:if test="${not empty imgQR}">
                    	<div class="alert alert-success" id="imgQRDiv">
    	                	<form action='https://chart.googleapis.com/chart' method='POST' target="_blank">
    						  <input type='hidden' name='cht' value='qr' />
    						  <input type='hidden' name='chs' value='300x300' />
    						  <input type='hidden' name='chl' value='<c:url value="${imgQR}" />'/>
    						  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" id="codeQR">Created QR Code</button>
    						</form>
    					</div>

                        <script src='<c:url value="/resources/js/jqueryLogin.js" />'></script>
                    </c:if>

 				<form action="<c:url value="/login" />" method="post" class="form-signin">
					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input input id = "userName"  class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" id = "userPassword" data-validate="Enter password">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="contact100-form-checkbox">
 					<p> </p>
                        <a href="<c:url value="/signup" />" id="signup">Sign up</a>
                        <p> </p>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit" id="sign">
							Login
						</button>
					</div>

					<div class="text-center p-t-90">
						<a class="txt1" href="<c:url value="/signup" />" id="signup">Forgot Password?
						</a>
							
				</form>
			</div>
		</div>
	</div>
	
	<div id="dropDownSelect1"></div>

   <!-- jQuery -->
    <script src='<c:url value="/resources/js/jquery.js" />'></script>

	<script src='<c:url value="/resources/nuevo/vendor/jquery/jquery-3.2.1.min.js" />'></script>
	<script src='<c:url value="/resources/nuevo/vendor/animsition/js/animsition.min.js" />'></script>
	<script src='<c:url value="/resources/nuevo/vendor/bootstrap/js/popper.js" />'></script>
	<script src='<c:url value="/resources/nuevo/vendor/bootstrap/js/bootstrap.min.js" />'></script>
	<script src='<c:url value="/resources/nuevo/vendor/select2/select2.min.js" />'></script>
	<script src='<c:url value="/resources/nuevo/vendor/daterangepicker/moment.min.js" />'></script>
	<script src='<c:url value="/resources/nuevo/vendor/daterangepicker/daterangepicker.js" />'></script>
	<script src='<c:url value="/resources/nuevo/vendor/countdowntime/countdowntime.js" />'></script>
	<script src='<c:url value="/resources/nuevo/js/main.js" />'></script>

</body>
</html>
