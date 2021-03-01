package sumit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sumit.model.LoginModel;
import sumit.service.LoginService;
import sumit.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Log")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		LoginModel model=new LoginModel();
		model.setName(name);
		model.setPassword(password);
		
		LoginService logService=new LoginServiceImpl();
		 
		boolean b=logService.isValidateUser(model);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("Welcome.html");
			r.forward(request,response);
			
		}else {
			RequestDispatcher r=request.getRequestDispatcher("login.html");
			r.include(request,response);
			out.println("<center>invalid user or password</center>");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
