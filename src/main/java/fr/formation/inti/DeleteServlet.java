package fr.formation.inti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.service.EmployeeService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeService();
	private static final Log log = LogFactory.getLog(DeleteServlet.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("methode doGet : del");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String empId = request.getParameter("id");
		
		
		service.delete(Integer.parseInt(empId));
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/employee");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("methode doPost : del");
		doGet(request, response);
	}

}
