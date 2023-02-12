package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("이거 실행되나..?");
		/*
		 * Get방식으로 요청하면 해당 doGet메서드가 호출됨.
		 * 
		 * 첫번째 매개변수인 HttpServletRequest request에는 요청시 전달된 내용들이 담기(사용자가 입력한 값, 요청 전송방식, 요청한 사용자의 ip 등등..)
		 * 
		 * 두번째 매개변수인 HttpServletResponse에는 요청 처리 후 응답을 할때 사용하는 객체.
		 * 
		 * 우선, 요청을 처리하기 위해 요청시 전달된 값(사용자가 입력한 값)들을 뽑는다.
		 * request의 parameter영역안에 존재함(key-value 형태로 담겨있음)
		 * 
		 * 따라서 request의 parameter 영역으로부터 전달된 데이터를 뽑는 메소드
		 * - request.getParameter("키값") : String(그에 해당하는 value값) -> "무조건" 문자열로 반환됨(형변환필요)
		 * - request.getParameterValues("키값") : String[](그에 해당하는 value값들)
		 * -> 하나의 key값으로 여러개의 value들을 받을경우(체크박스)문자열 배열형태로 반환됨.
		 */
		String name = request.getParameter("name"); // 이범석 / ""(텍스트 상자가 빈경우 빈 문자열이 넘어감)
		String gender = request.getParameter("gender"); // "M" , "F" (라디오 버튼이 체크되지 않은 경우 null이 넘어옴)
		int age = Integer.parseInt(request.getParameter("age")); // "20" -> 20  , 빈문자열로 넘어온 경우 ""-> 에러가 발생할수 있다.
		String city =  request.getParameter("city"); // 서울
		double height = Double.parseDouble(request.getParameter("height")); // "160" => 160.0
		
		// food -> 체크박스 같은 복수개의 정보를 받을때는 배열로 받아야함
		String [] foods = request.getParameterValues("food");//{"한식","일식"} // 체크박스 미클릭시 null
		
		System.out.println("name : "+name);
		System.out.println("gender : "+gender);
		System.out.println("age : "+age);
		System.out.println("city : "+city);
		System.out.println("height : "+height);
		
		if(foods == null) {
			System.out.println("foods : 없음");
		}else {
			System.out.println("foods : "+String.join(",", foods));			
		}
		// 이 뽑아낸 값들을 가지고 요청처리를 해야합니다(필요하다면 db에 접근해서)
		// 보토의 흐름 : Service의 메소드 호출시 뽑은 값들 전달 - Dao호출 - DB sql 실행 - 결과반환
		
		// * response 객체를 통해 사용자에게 html(응답화면) 전달
		// 1) 이제부터 내가 출력할 내용은 문서형태의 html이고 문자셋은 utf-8이라는 것을 지정.
		response.setContentType("text/html; charset=UTF-8");
		
		//2) 응답하고자 하는 사용자(요청했던 사용자)와의 스트림(클라이언트와의 통로) 생성.
		PrintWriter out = response.getWriter();
		
		// 3) 생성된 스트림을 통해 응답 html을 구현
		out.println("<html>");
		out.println("<head>");
		
		out.println("<style>");
		out.println("h2 {color:red}");
		out.println("#name {color:orange}");
		out.println("#age {color:yellow}");
		out.println("#city{color:green}");
		out.println("#height {color:pink}");
		out.println("#gender {color:navy}");
		out.println("li {color:purple}");
		out.println("</style>");
		out.println("</head>");
		
		out.println("<body>");
		out.printf("<span id='name'>%s</span>님은 ",name);
		out.printf("<span id='age'>%d</span>살이며 ",age);
		out.printf("<span id='city'>%s</span>에 사는 ",city);
		out.printf("<span id='height'>%.1f</span>cm 이고 ",height);
		
		out.print("성별은 ");
		if(gender == null) {
			out.print("선택을 안했습니다. <br>");
		}else {
			if(gender.equals("M")) {
				out.print("<span id='gender'>남자</span>입니다. <br>");
			}else {
				out.print("<span id='gender'>여자ㅣ</span>입니다. <br>");
			}
		}
		
		out.print("좋아하는 음식은");
		if(foods == null) {
			out.print("없습니다.");
		}else {
			out.print("<ul>");
			
			for(int i=0; i<foods.length; i++) {
				out.printf("<li>%s</li>", foods[i]);
			}
			
			out.print("</ul>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
