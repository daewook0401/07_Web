<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myWebHeader</title>
<style>
    .hobby-wrap{
        display: flex;
        justify-content: center;
        flex-direction: row;
        flex-wrap: nowrap;
        align-items: baseline;
    }
    input[type=checkbox]{
        margin-left : 50px;
    }
    .header-div1{
        width: 100%; 
        height: 50px; 
        background-color: #f5f5f5; 
        border-bottom: 1px solid #e3e3e3;
        
    }
    .header-div2{
        width: 80%;
        margin: auto;
        padding: 10px;
    }
    .header-div3{
        float: left;
    }
</style>
</head>
<body>
	<div class="header-div1">
        <div class="header-div2">
            <div class="header-div3">
                <h1 style="margin: 0; padding: 0;">myWeb</h1>
            </div>
            <div class="header-div3" style="float: right;">
                <c:if test="${empty sessionScope.userId}">
                    <a href="/login.jsp">로그인</a>
                    <a href="/signup.jsp">회원가입</a>
                </c:if>
                <c:if test="${not empty sessionScope.userId}">
                    <a href="/logout.jsp">로그아웃</a>
                    <a href="/my_page.jsp">마이페이지</a>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>