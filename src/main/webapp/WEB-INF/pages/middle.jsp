<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:choose>
    <c:when test="${setting.themePatternType eq 'threecolumn'}" >
        <c:set var="width" value="6"/>
    </c:when>

    <c:when test="${setting.themePatternType eq 'twocolumn_left'}" >
        <c:set var="width" value="9"/>
    </c:when>

    <c:when test="${setting.themePatternType eq 'twocolumn_right'}" >
        <c:set var="width" value="9"/>
    </c:when>

    <c:otherwise>
        <c:set var="width" value="12"/>
    </c:otherwise>
</c:choose>

<div class="col-lg-${width} col-md-${width} col-sm-${width}" id="middle" name="middle">

    <c:forEach items="${post}" var="post">

        <div id="post${post.id}" name="post${post.id}">
            <a id="post-title" href="#" ><h3>${post.title}</h3></a>
            <div class="row" id="post-data">

                <div class="col-lg-3" id="author" name="author">Posted by:
                    <a href="<c:url value="/user?id=${post.author.id}"/>">${post.author.nickname}</a>
                </div>
                <div class="col-lg-5" id="category">Category:
                    <a href="<c:url value="/category?id=${post.category.id}"/>">${post.category.categoryName}</a>
                </div>
                <div class="col-lg-4" id="post-date" name="post-date">${post.datePosted}</div>
            </div>
            <hr/>
            <div class="col-lg-12" id="post-content" name="post-content">${post.text}</div>
            <a class="btn btn-primary" id="more-link" href="<c:url value="/post?id=${post.id}"/>">Читать далие</a>
            <a class="btn btn-danger" id="delete" href="<c:url value="/delete?id=${post.id}"/>">Delete</a>
            <hr/>
        </div>
    </c:forEach>
</div>