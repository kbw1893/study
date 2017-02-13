package notice.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/list")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 전체 조회 출력 컨트롤러
		NoticeDao ndao = new NoticeDao();
		List<Notice> list = ndao.selectAll();
		
		if(list != null){
			RequestDispatcher rd = 
					request.getRequestDispatcher("listView.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else{
			//전체 조회 실패인 경우
			RequestDispatcher rd = 
					request.getRequestDispatcher("error.jsp");
			request.setAttribute("code", "listFail");
			rd.forward(request, response);
		}
			
	}

}
