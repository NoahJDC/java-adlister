
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.title}</title>
</head>
<body>
<form action="/pickcolor" method="POST">
    <h1>What's your favorite color?</h1>
    <input type="text" name="color" placeholder="Input favorite color">
    <button type="submit">Submit</button>

</form>

</body>
</html>
