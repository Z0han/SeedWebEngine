<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>
    <div class="container">
        <div class="row" id="top-nav">
            <div class="head-btn"><a class="btn btn-warning"  href="<c:url value="http://localhost:8070"/>">Home</a></div>

            <sec:authorize access="!isAuthenticated()">
                <div class="auth-btn"><a class="btn btn-success" href="<c:url value="/registration"/> ">Registration</a></div>
                <div class="auth-btn"><a class="btn btn-success" href="<c:url value="/login"/> " role="button">Войти</a></div>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div class="auth-btn"><a class="btn btn-danger" id="auth-bth" href="<c:url value="/logout"/> " role="button">Выйти</a></div>
                <div class="auth-btn"><a class="btn btn-info" href="<c:url value="/swe-admin/"/> ">Admin Panel</a></div>
                <div class="auth-btn" style="color: #fff">Ваш логин: <sec:authentication property="principal.username" /></div>
            </sec:authorize>

        </div>
        </div>
    </div>
</header>