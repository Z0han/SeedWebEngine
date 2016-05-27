<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<div class="col-lg-6 col-md-6 col-sm-6" id="middle" name="middle">

    <c:forEach items="${post}" var="post">
        <div id="post" name="post">
            <a id="post-title" href="#" ><h3>${post.title}</h3></a>
            <div class="row" id="post-data">
                <div class="col-lg-3" id="author" name="author">Posted by: <a href="#">${post.authorId}</a></div>
                <div class="col-lg-4" id="post-date" name="post-date">${post.datePosted}</div>
            </div>
            <hr/>
            <div class="col-lg-12" id="post-content" name="post-content">${post.text}</div>
            <a class="btn btn-primary" id="more-link" href="#">Читать далие</a>
            <a class="btn btn-danger" id="delete" href="/delete?id=${post.id}">Delete</a>
            <hr/>
        </div>

    </c:forEach>
</div>