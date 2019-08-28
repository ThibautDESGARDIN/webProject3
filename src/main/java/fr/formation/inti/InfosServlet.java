package fr.formation.inti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfosServlet
 */
@WebServlet("/infos/exemple")
public class InfosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getRequestURL().toString();
		String requestURI = request.getRequestURI().toString();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String host = request.getServerName();
		int port = request.getServerPort();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<heads>");
		out.println("<title>Servlet infow !</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Hellow !</h1>");
		out.println("<br><span><Strong>Request URL : "+requestURL+"</Strong></span><br><br>");
		out.println("<br><span>Request URI : "+ requestURI+"</span><br><br>");
		out.println("<br><span>Context Path : "+ contextPath +"</span><br><br>");
		out.println("<br><span>Servlet Path : "+ servletPath +"</span><br><br>");
		out.println("<br><span>Host : "+ host +"</span><br>");
		out.println("<br><span>Host : "+ request.getParameter("Param1") +"</span><br>");
		out.println("</body>");
		out.println("</html>");
		
//		this.getServletContext().setAttribute("testadd", "testadd");
		this.getServletContext().removeAttribute("testadd");
		
		//il faut 2 servlets different pour réussir à remove (sinon il est remplacé apr le redemarrage du server)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
