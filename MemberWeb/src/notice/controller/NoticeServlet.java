package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.PageData;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/notice")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전송값에 한글이 있을 경우 인코딩처리
		// 2. view 에서 보낸 전송값 변수 지정
		// 3. 비즈니스 로직을 처리할 서비스 클래스 메소드로 
		// 값을 전달 및 결과 받기
		
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage =1;
		}else {
			currentPage = Integer.parseInt(
					request.getParameter("currentPage"));
		}
		
		PageData pageData= new NoticeService().selectNoticeList(currentPage);
		
		RequestDispatcher view= request.getRequestDispatcher("/views/notice/noticeAll.jsp");
		request.setAttribute("pageData", pageData);
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
