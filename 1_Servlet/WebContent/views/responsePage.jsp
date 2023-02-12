<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   /*
      이 구문을 스트립틀릿이라고 해서 html문서 내에 자바코드를 쓸수 있는 영역
      현재 이 jsp에서 필요로 하는 데이터들 -> request의 attribute에 담겨있음.
      request.getAttribute("키값") : Object
      반환값은 Object이기때문에 내가 받고자 하는 자료형으로 강제형변환 시켜줘서 담아야한다.
   */
   String name = (String) request.getAttribute("name");
   int     age = (int) request.getAttribute("age");
   String gender = (String) request.getAttribute("gender");
   String city = (String) request.getAttribute("city");
   double height = (double) request.getAttribute("height");
   String[] foods = (String[]) request.getAttribute("foods");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   h2{color:red;}
   span{font-weight:bold}
   #name{color:orange}
   #age{color:yellow}
   #city{color:green}
   #height{color:pink}
   #gender{color:navy}
   li{color:purple}
</style>
</head>
<body>

   <h2>개인정보 응답화면</h2>
   
   <span id = "name"><%= name %></span>님은 
   <span id = "age"><%= age %></span> 살이며,
   <span id = "city"><%= city %></span> 에 살고,
   <span id = "height"><%= height %></span> cm이고,
   
   성별은 
   <% if(gender == null){ %>
      선택을 안했습니다.<br>
   <% } else { %>
      <span id = "gender"><%= gender.equals("M") ? "남자" : "여자" %></span> 입니다.<br>
   <% } %>
   
   좋아하는 음식은 
   
   <% if(foods == null) { %>
      없습니다.
   <% } else { %>
      <ul>
      <% for(int i = 0; i < foods.length; i++) { %>
         <li><%=foods[i]%></li>
      <% } %>
      </ul>
   <% } %>
   
   
</body>
</html>