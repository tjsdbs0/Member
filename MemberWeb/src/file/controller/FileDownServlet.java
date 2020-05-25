package file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

/**
 * Servlet implementation class FileDownServlet
 */
@WebServlet("/fileDown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filePath = request.getParameter("filePath");
		String fileUser = request.getParameter("fileUser");
		
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("member")).getUserId();
		if(fileUser.equals(userId)) {
			File file = new File(filePath);
			String fileName = new String(file.getName().getBytes(), "ISO-8859-1");
			response.setContentType("application/octet-stream");
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			
			FileInputStream fileIn = new FileInputStream(file);
			ServletOutputStream out = response.getOutputStream();
			
			byte[] outputByte = new byte[4096];
			
			while(fileIn.read(outputByte,0,4096) != -1) {
				out.write(outputByte, 0, 4096);
			}
			fileIn.close();
			out.flush();
			out.close();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
