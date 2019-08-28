package fr.formation.inti.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.IntiParamServlet;

/**
 * Servlet Filter implementation class PremierFilter
 */
@WebFilter(filterName="premierFilter")
public class PremierFilter implements Filter {
	private static final Log log = LogFactory.getLog(PremierFilter.class);

    /**
     * Default constructor. 
     */
    public PremierFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		log.info("premier filtre : ");
//		response.getWriter().append("<h1>VOUS NE PASSEREZ PAAAAAAS !</h1>");
//		request.getServletContext().getRequestDispatcher("/infos/exemple").forward(request, response);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
