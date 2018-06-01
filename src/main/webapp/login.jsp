<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    if("POST".equals(request.getMethod())) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
            response.sendRedirect("profile.jsp");
        }
    };
%>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<%@ include file="partials/index.css" %>
<%@ include file="partials/navbar.jsp" %>
<%@ include file="partials/head.jsp" %>
    <h1>Please login</h1>
    <form action="login.jsp" method="POST">
        <div>
            <label for="username">Email Address</label>
            <br>
            <input id=username name="username" type="text" placeholder="Enter email">
        </div>
        <br>
        <div>
            <label for="password">Password</label>
            <br>
            <input id=password name="password" type="password" placeholder="Password">
        </div>
        <br>
        <button type="submit">Login</button>
    </form>
</body>
</html>
