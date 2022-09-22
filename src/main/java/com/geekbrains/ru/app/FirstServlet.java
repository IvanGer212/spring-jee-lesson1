package com.geekbrains.ru.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");

        //resp.getWriter().printf("<html><body><h1>New GET request</h1></body></html>");
        resp.getWriter().printf("<html><body>");

        resp.getWriter().printf("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Log: POST");
        resp.getWriter().printf("<html><body><h1>New POST request</h1></body></html>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }

}