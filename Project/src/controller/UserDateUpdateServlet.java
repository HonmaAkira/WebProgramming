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
 * Servlet implementation class UserDateUpdateServlet
 */
@WebServlet("/UserDateUpdateServlet")
public class UserDateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDateUpdateServlet() {
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

		String  Id = request.getParameter("id");

		UserDao userdao = new UserDao();
		User user=userdao.Findid(Id);


		request.setAttribute("user",user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDateUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("id");
		String Pass = request.getParameter("pass1");
		String copypass = request.getParameter("pass2");
		String User = request.getParameter("user");
		String Birth = request.getParameter("birth");

		if(!Pass.equals(copypass)) {
			request.setAttribute("fail","入力された内容は正しくありません");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/UserDateUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}else if(User.equals("")||Birth.equals("")) {
			request.setAttribute("fail","入力された内容は正しくありません");
			RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/UserDateUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}else if(Pass.equals("")&&copypass.equals("")) {
			UserDao userdao =new UserDao();
			userdao.NonPassUpdate(User,Birth,Id);
			response.sendRedirect("UserListServlet");
			return;
		}

		UserDao userdao =new UserDao();
		userdao.AllUpdate(Pass,User,Birth,Id);


		response.sendRedirect("UserListServlet");
	}

}
