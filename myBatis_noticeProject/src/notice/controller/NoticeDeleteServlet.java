package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.dao.NoticeDao;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/ndelete")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글삭제 처리용 컨트롤러
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDao ndao = new NoticeDao();
		int result = ndao.deleteNotice(no);
		
		if(result > 0){
			response.sendRedirect("list");
		}else{
			RequestDispatcher rd =
				request.getRequestDispatcher("error.jsp");
			request.setAttribute("code", "deleteFail");
			rd.forward(request, response);
		}
	}

}
