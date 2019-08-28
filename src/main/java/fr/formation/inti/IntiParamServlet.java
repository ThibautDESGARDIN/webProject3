package fr.formation.inti;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class IntiParamServlet
 */
@WebServlet(urlPatterns = "/init", 
initParams = {
		@WebInitParam(name="id", value="150"),
		@WebInitParam(name="url",value="http:\\test"),})
public class IntiParamServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(IntiParamServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public IntiParamServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//methode 2 pour recuperer un init-param
		log.info("doGet : " + this.getServletConfig().getInitParameter("url")); 
		
		//import depuis le web.xml
		//methode pour recuperer un context-param
		log.info("context-param : "+this.getServletContext().getInitParameter("email")); 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//methode 1 pour recuperer un init-param
		log.info("init : " + config.getInitParameter("id")); 
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
