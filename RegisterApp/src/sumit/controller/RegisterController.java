package sumit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sumit.model.Register;
import sumit.service.RegisterService;
import sumit.service.RegisterServiceImpl;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/reg")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		out.println("welcome");
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String username=request.getParameter("username");
     	String password=request.getParameter("password");
		  
		
		Register r=new Register();
		r.setName(name);
		r.setEmail(email);
		r.setContact(contact);
		r.setUsername(username);
		r.setPassword(password);
		
		RegisterService rs=new RegisterServiceImpl();
		 
		boolean b=rs.isRegisterUser(r);
		if(b) {
			out.println("<h1>Registration Successfully</h1>");
		}else {
			out.println("<h1>Registration Failed</h1>");
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
