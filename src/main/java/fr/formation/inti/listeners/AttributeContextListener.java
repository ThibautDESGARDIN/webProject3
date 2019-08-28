package fr.formation.inti.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class AttributeContextListener
 *
 */
@WebListener
public class AttributeContextListener implements ServletContextAttributeListener {
	private static final Log log = LogFactory.getLog(AttributeContextListener.class);
    /**
     * Default constructor. 
     */
    public AttributeContextListener() {
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
    	log.info("_____ Attribute added _____");
    	log.info("Name : "+event.getName()+" value : "+event.getValue());

    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	log.info("_____ Attribute removed _____*");
    	log.info("Name : "+event.getName()+" value : "+event.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	log.info("_____ Attribute replaced _____");
    	log.info("Name : "+event.getName()+" value : "+event.getValue());
    }
	
}
