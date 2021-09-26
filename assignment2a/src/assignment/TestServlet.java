//created by Neil Jones, 9/25/2021, CST-235
//This is my own work with help from the following
//Help from my dad
//https://www.youtube.com/watch?v=_6ISkXSC1js&list=PLsyeobzWxl7pUPF2xjjJiG4BKC9x_GY46&index=7

package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	System.out.println("init() called");
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() called");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() called");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("TestResponse.jsp");
		requestDispatcher.forward(request, response);
		
		String f = request.getParameter("fName");
		String l = request.getParameter("lName");
		
		PrintWriter out = response.getWriter();
		
		out.println("The first name is " + f + " and the last name is " + l);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("fName");
		String l = request.getParameter("lName");
		
		PrintWriter out = response.getWriter();
		
		out.println("The first name is " + f + " and the last name is " + l);
		doGet(request, response);
	}

}
