<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${setting}" var="setting" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${setting.siteTitle} - ${setting.siteDescription}</title>

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
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</head>
<body>

<c:import url="header.jsp"/>

<div class="container">

    <div class="row" id="general">
        <c:if test="${setting.themePatternType eq 'threecolumn'|| setting.themePatternType eq 'twocolumn_left'}">
            <c:import url="left-bar.jsp"/>
        </c:if>

            <c:import url="middle.jsp">
                <c:param name="setting" value="setting"/>
            </c:import>

        <c:if test="${setting.themePatternType eq 'threecolumn'|| setting.themePatternType eq 'twocolumn_right'}">
            <c:import url="right-bar.jsp"/>
        </c:if>

    </div>
</div>

<c:import url="footer.jsp"/>

</body>
</html>