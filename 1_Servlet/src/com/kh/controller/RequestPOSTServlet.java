package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPOSTServlet
 */
@WebServlet("/test2.do")// 1_Servlet/test2.do
public class RequestPOSTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPOSTServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("잘 실행되나??");
		
		// 요청시 전달된 값들은 request parameter영역에 담겨있습니다.
		
		// POST 방식 요청 같은 경우 값을 뽑기전에 UTF-8 방식으로 인코딩 설정을 변경해야한다.
		// POST방식 요청시 기본인코딩 값이 ISO-8859-1이기 때문.
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name"); // "홍길동", ""
		String gender = request.getParameter("gender"); // "M", "F", null
		int age = Integer.parseInt(request.getParameter("age")); // "20" -> 20 빈 공간으로 넘어온 경우 에러발생
		String city = request.getParameter("city");
		double height = Double.parseDouble(request.getParameter("height")); // 160 -> 160.0
		
		String[] foods = request.getParameterValues("food");
		
		System.out.println("name : "+name);
		System.out.println("gender : "+gender);
		System.out.println("age : "+age);
		System.out.println("city : "+city);
		System.out.println("height : "+height);
		System.out.println("foods : "+(foods == null ? "없음" : String.join(",", foods)));
		
		// 현재 얻어온 데이터를 응답페이지를 만들어서 해당 jsp파일에 넘겨주려고함.
		// jsp파일로 데이터들을 넘겨줄때 request객체에 담아서 attribute영역에 넘겨줘야한다.
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
		// 위임시 필요한 객체 : RequestDispatcher
		// 1) 응답하고자 하는 뷰(jsp)를 선택하면서 생성.
		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		
		// 2) 포워딩
		view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
