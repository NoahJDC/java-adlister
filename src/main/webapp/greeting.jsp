<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.title}</title>
</head>
<body>
<h1>Enter Name</h1>
<form action="/name" method="POST">
    <input type="text" name="name" placeholder="Enter Name Here">
    <button type="submit">Submit</button>
</form>
</body>
</html>
