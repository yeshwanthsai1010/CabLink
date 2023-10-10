package com.src.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.src.model.Admin;
import com.src.model.Booking;
import com.src.model.Passenger;
import com.src.model.PermDriver;
import com.src.model.Request;
import com.src.model.TempDriver;

/**
 * Application Lifecycle Listener implementation class LoadModels
 *
 */
public class LoadModels implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoadModels() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	new Admin();
    	new Passenger();
    	new PermDriver();
    	new TempDriver();
    	new Request();
    	new Booking();
    }
	
}
