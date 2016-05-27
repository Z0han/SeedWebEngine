<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <div class="container">
        <div class="row" id="top-nav">
            <div id="addbtn"><form class="form-inline" role="form" action="/addpage" method="post">
                <input type="submit" class="btn btn-default" value="Add new">
            </form></div>
            <div><a class="btn btn-success" href="/registration">Registration</a></div>
        </div>
    </div>
</header>