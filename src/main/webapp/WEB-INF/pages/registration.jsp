<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
<body>

    <div class="container" style="width: 300px;">
        <form action="<c:url value="/adduser"/>" method="post">
            <h2 class="form-signin-heading">Please sign up</h2>
            <div class="form-group"><input type="text" class="form-control" name="nick" placeholder="Nick name"></div>
            <div class="form-group"><input type="email" class="form-control" name="email" placeholder="email"></div>
            <div class="form-group"><input type="password" class="form-control" name="password" placeholder="password"></div>
            <button class="btn btn-success" type="submit">Sign up</button>
        </form>
    </div>

</body>
</html>
