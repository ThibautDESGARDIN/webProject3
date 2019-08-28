package fr.formation.inti.login;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.NouvelEmployee;
import fr.formation.inti.entities.Employee;
import fr.formation.inti.service.EmployeeService;

/**
 * Servlet implementation class ReccordServlet
 */
@WebServlet("/reccord")
public class ReccordServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(ReccordServlet.class);
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReccordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		log.debug("Reccord - Method post :");
		
	//// on crée notre objet service pour pouvoir utilisé ses méthodes qui sont dans l'interface EmployeeService
			Employee emp = new Employee();
	
			emp.setFirstName(request.getParameter("identifiants"));
			emp.setLastName(request.getParameter("pass"));
			
			service.save(emp);	

		
			Integer id = service.save(emp);
			if(id != null) {
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/employee");
			}else {
				
			}
	}

}
