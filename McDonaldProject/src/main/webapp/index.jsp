<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP문법 배우기</title>
<style>
	a{
		text-decoration : none;
		color : black;
	}
</style>


</head>
<body>
	<h1>* EL(Expression Language)표현 언어</h1>
	
	<p>
		기존 JSP상에 사용했던 &lt;%= %>(출력식)같은 경우 사용이 복잡하고, <br/>
		컴파일 시 문제가 발생할 수 있기 때문에 <br/>
		이 문제를 대체 할 수 있는 문법
	</p>
	<h3>1. EL구문 기본학습</h3>
	
	<!-- 
		절대 경로 방식 : /bm/sc
		상대 경로 방식 : "sc" 마지막 슬래시 뒤에 붙음
	 -->
	<a href="sc">a 태그</a>
	
	<hr>
	
	<a href="include">포함포함 해야지</a> <br/>
	<hr>
	<a href="forward">포워드 JSP로 이동</a>
	<hr>
	
	<a href="jstl">실과바늘 배우러가기</a>
	
</body>
</html>