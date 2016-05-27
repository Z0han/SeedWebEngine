<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
</head>
<body>

    <div class="container">
        <div class="col-lg-4 col-md-4"></div>
        <div class="col-lg-4 col-md-4">
            <form class="form-horizontal" role="form" action="/adduser" method="post">
                <div class="form-group"><input type="email" class="form-control" name="email" placeholder="email"></div>
                <div class="form-group"><input type="password" class="form-control" name="password" placeholder="password"></div>
                <button class="btn btn-success" type="submit">ok</button>
            </form>
        </div>
        <div class="col-lg-4 col-md-4"></div>
    </div>
</body>
</html>
