package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;


/**
 * Servlet implementation class NewUserEntryServlet
 */
@WebServlet("/NewUserEntryServlet")
public class NewUserEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("userinfo")==null) {
			response.sendRedirect("LoginServlet");
			return;

		}
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/NewUserEntry.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginId = request.getParameter("login_id");
		String password = request.getParameter("pass1");
		String copypass = request.getParameter("pass2");
		String username = request.getParameter("username");
		String birth = request.getParameter("birthdate");

		UserDao userdao =new UserDao();
		User user =userdao.Findlogin_id(loginId);
		if(!password.equals(copypass)) {
			request.setAttribute("fail", "入力された内容は正しくありません");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/NewUserEntry.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if(loginId.equals("") || password.equals("") ||copypass.equals("")
				||username.equals("") ||birth.equals("")) {
			request.setAttribute("fail", "入力された内容は正しくありません");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/NewUserEntry.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else if(userdao.Findlogin_id(loginId) != null) {
			request.setAttribute("fail", "入力された内容は正しくありません");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/NewUserEntry.jsp");
			dispatcher.forward(request, response);
			return;
		}



		userdao.IncreaseUser(loginId,username,birth,password);


		response.sendRedirect("UserListServlet");

			}

}
