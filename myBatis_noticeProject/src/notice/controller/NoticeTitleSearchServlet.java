package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeTitleSearchServlet
 */
@WebServlet("/nsearch")
public class NoticeTitleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeTitleSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 제목 검색 컨트롤로 메소드
		request.setCharacterEncoding("utf-8");
		
		String searchWord = request.getParameter("word");
		
		NoticeDao ndao = new NoticeDao();
		List<Notice> list = ndao.searchTitle(searchWord);
		
		if(list != null){
			RequestDispatcher rd = 
					request.getRequestDispatcher("listView.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else{
			RequestDispatcher rd =
					request.getRequestDispatcher("error.jsp");
			request.setAttribute("code", "searchFail");
			rd.forward(request, response);
		}
	}

}
