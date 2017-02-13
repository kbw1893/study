package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/ninsert")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새 공지글 추가 처리 
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("ntitle");
		String writer = request.getParameter("nwriter");
		String content = request.getParameter("ncontent");
		
		Notice notice = new Notice(0, title, writer, null, content);
		
		NoticeDao ndao = new NoticeDao();
		int result = ndao.insertNotice(notice);
		
		if(result > 0){
			response.sendRedirect("list");
		}else{
			RequestDispatcher rd =
				request.getRequestDispatcher("error.jsp");
			request.setAttribute("code", "insertFail");
			rd.forward(request, response);
		}
	}

}
