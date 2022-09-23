package com.geekbrains.ru.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;


public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");
        ArrayList<Product> products = new ArrayList<>();

        //resp.getWriter().printf("<html><body><h1>New GET request</h1></body></html>");
        resp.getWriter().printf("<html><body>");
        final Random random = new Random();
        Stream<Product> productStream = products.stream();

        for (int i = 1; i <= 10; i++) {
            products.add(new Product(i,"product"+i, round(random.nextDouble()*i*1000)));
        }
        productStream.forEach(p-> {
            try {
                resp.getWriter().printf("<h1>"+p.toString()+"</h1>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
    private static double round (double value){
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}