package photo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import photo.model.service.PhotoService;
import photo.model.vo.Photo;

/**
 * Servlet implementation class insertPhotoServlet
 */
@WebServlet("/insertPhoto")
public class insertPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//multipart인지 확인
				if(!ServletFileUpload.isMultipartContent(request)) {
					RequestDispatcher rd 
					= request.getRequestDispatcher
					("/WEB-INF/views/common/msg.jsp");
					request.setAttribute("msg", "[enctype]확인");
					request.setAttribute("loc", "/");
					rd.forward(request, response);
					return;
				}
				//파일 저장 경로 설정
				String root = 
						request.getSession().
						getServletContext().
						getRealPath("/");
				String saveDirectory = root+"upload/photo";
				//파일 최대 크기 설정
				int maxSize = 10*1024*1024;
				//request -> MultipartRequest 파일업로드 진행
				MultipartRequest mRequest = 
						new MultipartRequest(request, 
								saveDirectory,
								maxSize,
								"UTF-8"
								,new DefaultFileRenamePolicy());
				String photoWriter 
				= mRequest.getParameter("photoWriter");
				String photoContent 
				= mRequest.getParameter("photoContent");
				String filename 
				= mRequest.getOriginalFileName("filename");
				String filepath 
				= mRequest.getFilesystemName("filename");
				Photo p = new Photo();
				p.setPhotoContent(photoContent);
				p.setPhotoFilename(filename);
				p.setPhotoFilepath(filepath);
				p.setPhotoWriter(photoWriter);
				//비지니스로직처리
				int result 
				= new PhotoService().insertPhoto(p);
				RequestDispatcher rd 
				= request.getRequestDispatcher
				("/WEB-INF/views/common/msg.jsp");
				request.setAttribute("loc", "/photoList");
				if(result>0) {
					request.setAttribute("msg", "등록 성공");
				}else {
					request.setAttribute("msg", "등록 실패");
				}
				rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
