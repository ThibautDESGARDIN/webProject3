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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UpdateServlet.class);

	EmployeeService service = new EmployeeService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("methode doGet : update");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Employee em = new Employee();
		
		em.setEmpId(Integer.parseInt("id"));
		em.setFirstName(request.getParameter("firstName"));
		em.setLastName(request.getParameter("lastName"));
		Date date;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter.parse(request.getParameter("start"));
			em.setStartDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		service.update(em);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/employee");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("methode doPost : update");
		doGet(request, response);
	}

}
