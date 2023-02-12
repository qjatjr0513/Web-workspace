<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("pizza");
	String[] toppings = (String[])request.getAttribute("toppings");
	String[] sides = (String[])request.getAttribute("sides");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>주문 내역</h1>
	<h2>피자는 <span style="color:red;"><%=pizza %></span>, 토핑은 <span style="color:green;"><%= toppings== null? "선택안함" : String.join(", ",toppings) %></span>, 사이드는
 	<span style="color:blue;"><%= sides==null? "선택안함" : String.join(", ",sides) %></span> 주문하셨습니다.
 	</h2>
   	
   	<br>
   	
	<b>
	총합: <u><%=price %>원</u>
	</b>
	<br>
	<br>
	<h1 style="color:pink;">즐거운 식사시간 되세요~</h1>
</body>
</html>