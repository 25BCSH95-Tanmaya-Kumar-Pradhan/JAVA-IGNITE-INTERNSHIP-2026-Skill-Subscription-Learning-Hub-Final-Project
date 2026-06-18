<!--
	Why it is used:

This page shows available training packs / courses / subscription plans.

What it does:
Displays list of courses or packages
Shows price, duration, features
Lets user choose a plan
Why it is needed:

This is the main business page of your system:

It converts users into customers
Helps users decide what to buy/enroll
Simple flow:

User - logs in -views packs - selects a plan
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Skill Packs</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<div class="header">
    <img src="/images/logo.png">
    <h2>Available Skill Packs</h2>
	<p>Logged in as: <b>${loggedInUser.name}</b></p>
	<a href="/login">
	    <button>Login</button>
		</a>
</div>

<div class="container">

    <h3>All Courses</h3>
	
    <!--  loop skill packs -->
    <c:forEach var="pack" items="${packs}">

        <div class="card">

            <!--  show title -->
            <h4>${pack.title}</h4>

            <!--  show description -->
            <p>${pack.description}</p>

            <!--  show price -->
            <b>₹ ${pack.price}</b>

            <br><br>
			<!-- Update Pack -->
			<form action="/update-pack" method="post">

			    <input type="hidden" 
			           name="id" 
			           value="${pack.id}">


			    <input type="text" 
			           name="title" 
			           value="${pack.title}">


			    <input type="text" 
			           name="description" 
			           value="${pack.description}">


			    <input type="text" 
			           name="price" 
			           value="${pack.price}">


			    <button type="button" onclick="checkRole(this)">
			       Update
				</button>


			</form>

			<!-- Subscribe Action -->
			<br>

			<c:if test="${not empty loggedInUser}">
				<c:choose>

				    <c:when test="${subscribedPackIds.contains(pack.id)}">
				        <span style="color:green;">
				            Already Subscribed ✅
				        </span>
				    </c:when>

				    <c:otherwise>
				        <a href="/subscribe?packId=${pack.id}">
				            Subscribe
				        </a>
				    </c:otherwise>

				</c:choose>
			</c:if>

			<c:if test="${empty loggedInUser}">
			    <a href="/login">
			        Login to Subscribe
			    </a>
			</c:if>

        </div>

    </c:forEach>

</div>
<script>

function checkRole(button){

    let role = prompt("Enter role (admin/user):");

    if(role === "admin"){

        let pin = prompt("Enter Admin PIN:");

        if(pin === "1234"){

            button.closest("form").submit();

        }
        else{

            alert("Wrong PIN");

        }

    }
    else if(role === "user"){

        alert("You are not eligible to update packs");

    }
    else{

        alert("Invalid role");

    }

}

</script>
</body>
</html>
