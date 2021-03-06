package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
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

		UserDao userDao = new UserDao();
		List<User> userlist=userDao.FindAll();

		request.setAttribute("userlist", userlist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUserList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	String loginId = request.getParameter("login_id");
	String username = request.getParameter("user");
	String birth1 = request.getParameter("birth1");
	String birth2 = request.getParameter("birth2");


	
	
	
	UserDao userdao =new UserDao();
	List <User> userlist = userdao.FindSearch(loginId, username, birth1, birth2);
	request.setAttribute("userlist",userlist);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUserList.jsp");
	dispatcher.forward(request, response);

	}





}
