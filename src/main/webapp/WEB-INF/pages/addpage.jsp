<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Post</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/resources/js/bootstrap.min.js.css'/>"></script>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">
    <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/swe-admin/addpost" method="post">
        <div class="form-group"><h3>New post</h3></div>


        <div class="form-group"><input type="text" class="form-control" name="title" placeholder="title"></div>
        <div class="form-group"><textarea type="text" class="form-control" rows="5" name="text" placeholder="text"></textarea></div>

        <div class="form-group"><input type="submit" class="btn btn-primary" value="Add"></div>
    </form>
</div>
<c:import url="footer.jsp"/>
</body>
</html>