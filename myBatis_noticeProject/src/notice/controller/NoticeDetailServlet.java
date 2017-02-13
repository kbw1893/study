package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.User;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/ndetail")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 상세보기 처리용 컨트롤러
		int no = Integer.parseInt(request.getParameter("no"));		
		
		HttpSession session = request.getSession(false);
			
		if(session == null){
			RequestDispatcher rd = 
				request.getRequestDispatcher("error.jsp");
			request.setAttribute("code", "Not Login");
			rd.forward(request, response);
		}else if(session != null){
						
			NoticeDao ndao = new NoticeDao();
			Notice n = ndao.selectOne(no);
			
			if(n != null){
				RequestDispatcher rd = 
					request.getRequestDispatcher("detailView.jsp");
				request.setAttribute("notice", n);
					rd.forward(request, response);
			}else{
				//상세조회가 실패한 경우
				RequestDispatcher rd = 
						request.getRequestDispatcher("error.jsp");
				request.setAttribute("code", "detailFail");
				rd.forward(request, response);
			}
		}
	}

}
