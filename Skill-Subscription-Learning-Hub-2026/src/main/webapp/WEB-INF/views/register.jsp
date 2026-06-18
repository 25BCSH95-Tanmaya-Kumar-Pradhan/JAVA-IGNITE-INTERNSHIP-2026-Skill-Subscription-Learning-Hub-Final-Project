<!--
	Why it is used:

	This is where a new user is created in the system.

	What it does:
	Collects user details (name, email, password, etc.)
	Sends data to backend
	Stores user in database
	Why it is needed:

	Without registration:

	No new users can join your system
	Login would be useless
	Simple flow:

	User - fills form -submits -data saved in DB - account created
-->
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<div class="header">
    <img src="/images/logo.png">
    <h2>Skill Subscription Hub</h2>
</div>

<div class="container">

    <h3>Register</h3>
	<c:if test="${not empty error}">
	    <p style="color:red;">
	        ${error}
	    </p>
	</c:if>
    <form action="/register" method="post">

        <!--  enter name -->
        <input type="text" name="name" placeholder="Name">

        <!--  enter email -->
        <input type="text" name="email" placeholder="Email">

        <!--  enter password -->
        <input type="password" name="password" placeholder="Password">

        <button type="submit">Register</button>

    </form>

</div>

</body>
</html>
