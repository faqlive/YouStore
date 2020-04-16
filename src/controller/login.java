package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import security.EncryptPass;
import services.IServiceUser;
import services.ServiceUser;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Inicializar session y definición de variables globales.
		HttpSession session = request.getSession(false);
		String nextpage="";
		if(session.getAttribute("nextpage")==null){
			nextpage ="/index.jsp";
		}else {
			nextpage =(String) session.getAttribute("nextpage");
		}
		
		User user = null;
		boolean access = false;
		String mensaje = "";
	// Recoger informacion del loging
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
	// Comprobación de inicio de session
		IServiceUser userService = new ServiceUser();
		user = userService.get(mail);
		if(user != null) {
			byte [] pass =EncryptPass.getPassDigest(password);
			byte [] pass2 = user.getPass();
			access = EncryptPass.equalsDigest(pass, pass2);	
			if(access) {
				mensaje = "Conexion exitosa, Bienvenido: " + user.getName() + " a YouStore";
				session =  request.getSession(true);
				session.setAttribute("access", access);
			}else {
				mensaje = "Password Incorrecta";
			}
		}else {
			mensaje = "Usuario no existe";
		}
	//	request.setAttribute("access", access);
		request.setAttribute("mensaje",mensaje);
		request.setAttribute("user",user);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(nextpage);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
