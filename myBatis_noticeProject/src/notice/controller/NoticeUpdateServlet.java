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
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/nupdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글수정하기 컨트롤러 메소드
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("ntitle");
		String content = request.getParameter("ncontent");
		
		Notice notice = new Notice(no, title, null, null, content);
		
		NoticeDao ndao = new NoticeDao();
		int result = ndao.updateNotice(notice);
		
		if(result > 0){
			response.sendRedirect("list");
		}else{
			RequestDispatcher rd =
				request.getRequestDispatcher("error.jsp");
			request.setAttribute("code", "updateFail");
			rd.forward(request, response);
		}
	}

}
