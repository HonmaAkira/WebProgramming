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
 * Servlet implementation class UserDateServlet
 */
@WebServlet("/UserDateServlet")
public class UserDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDateServlet() {
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

		System.out.println(Id);

		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		UserDao userdao = new UserDao();
		User user=userdao.Findid(Id);
		System.out.println();
		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
		request.setAttribute("user",user);

		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/Userdate.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
