
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Delete Ad</h1>
    <form action="/ads/delete" method="POST">
        <label for="title">Title</label>
        <input id="title" type="text" name="title">
    </form>
</div>

</body>
</html>
