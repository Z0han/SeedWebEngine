<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>add page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/addpost" method="post">
        <div class="form-group"><h3>New post</h3></div>

        <div class="form-group"><input type="text" class="form-control" name="autorId" placeholder="authorId"></div>
        <div class="form-group"><input type="text" class="form-control" name="title" placeholder="title"></div>
        <div class="form-group"><textarea type="text" class="form-control" rows="5" name="text" placeholder="text"></textarea></div>

        <div class="form-group"><input type="submit" class="btn btn-primary" value="Add"></div>
    </form>
</div>
</body>
</html>