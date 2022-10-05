package com.example.todo.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
@Log4j2
public class CountListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public CountListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("inited...................");
        log.info("inited...................");
        log.info("inited...................");
        log.info("inited...................");
        sce.getServletContext().setAttribute("Sample", new StringBuffer());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("destroyed.............");
        log.info("destroyed.............");
        log.info("destroyed.............");
        log.info("destroyed.............");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
