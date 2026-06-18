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

    <p>
        Logged in as:
        <b>${loggedInUser.name}</b>
    </p>

    <c:choose>

        <c:when test="${not empty loggedInUser}">
            <a href="/logout">
                <button>Logout</button>
            </a>
        </c:when>

        <c:otherwise>
            <a href="/login">
                <button>Login</button>
            </a>
        </c:otherwise>

    </c:choose>

</div>

<div class="container">

    <h3>All Courses</h3>

    <!-- Search Box -->
    <form action="/packs" method="get">

        <input type="text"
               name="keyword"
               placeholder="Search Skill Pack">

        <button type="submit">
            Search
        </button>

    </form>

    <br>

    <c:forEach var="pack" items="${packs}">

        <div class="card">

            <h4>${pack.title}</h4>

            <p>${pack.description}</p>

            <b>₹ ${pack.price}</b>

            <br><br>

            <!-- Update Form -->
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

                <button type="button"
                        onclick="checkRole(this)">
                    Update
                </button>

            </form>

            <br>

            <!-- Delete Button -->
            <a href="#"
               onclick="checkDeleteRole(${pack.id})">
                Delete
            </a>

            <br><br>

            <!-- Subscribe Section -->

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

function checkDeleteRole(packId){

    let role = prompt("Enter role (admin/user):");

    if(role === "admin"){

        let pin = prompt("Enter Admin PIN:");

        if(pin === "1234"){

            let confirmDelete = confirm(
                "Are you sure you want to delete this skill pack?"
            );

            if(confirmDelete){

                window.location.href =
                    "/delete-pack/" + packId;

            }

        }
        else{

            alert("Wrong PIN");

        }

    }
    else if(role === "user"){

        alert("You are not eligible to delete packs");

    }
    else{

        alert("Invalid role");

    }

}

</script>

</body>
</html>
