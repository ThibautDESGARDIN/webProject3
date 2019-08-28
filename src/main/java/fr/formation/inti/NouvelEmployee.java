package fr.formation.inti;

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

import fr.formation.inti.entities.Employee;
import fr.formation.inti.service.EmployeeService;

/**
 * Servlet implementation class NouvelEmployeeServlet
 */
@WebServlet("/new")
public class NouvelEmployee extends HttpServlet {
	private static final Log log = LogFactory.getLog(NouvelEmployee.class);
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouvelEmployee() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		doGet(request, response);
		log.debug("Method post new");
	
//// on crée notre objet service pour pouvoir utilisé ses méthodes qui sont dans l'interface EmployeeService
		Employee emp = new Employee();
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			date = formatter.parse(request.getParameter("start"));
			emp.setStartDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String firstname = request.getParameter("firstname");
		System.out.println(firstname);
		emp.setFirstName(firstname);
		emp.setLastName(request.getParameter("lastname"));
		
		service.save(emp);	

	
		Integer id = service.save(emp);
		if(id != null) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/employee");
		}else {
			
		}
	}
	
}


	