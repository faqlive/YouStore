package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfeces.IServiceUser;
import model.User;
import security.EncryptPass;
import services.ServiceUser;

/**
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =null;
		
		String mail = request.getParameter("email");
		String pass = request.getParameter("password");
		String name = request.getParameter("name");
		//TODO check usuario repetido.
		byte[] encodePass = EncryptPass.getPassDigest(pass);
		User user = new User(name,mail,encodePass);
		IServiceUser servicUser = new ServiceUser();
		servicUser.save(user);
		
		dispatcher = request.getRequestDispatcher("login.html");
		dispatcher.forward(request, response);
		
	/*	if(request.getCookies()!=null) {
			Cookie[] cookies = request.getCookies();
		}
	*/	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
