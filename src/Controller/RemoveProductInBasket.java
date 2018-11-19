package Controller;

import DAO.ProductDAO;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import Exception.*;

public class RemoveProductInBasket extends HttpServlet {
    private static final String ATTRIBUTE_SESSION = "AllProductInBasket";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        try {
            Product product = new ProductDAO().selectById(id);
            HttpSession session = req.getSession();
            Map<Product, Integer> basket = new LinkedHashMap<Product, Integer>((Map<Product, Integer>) session.getAttribute(ATTRIBUTE_SESSION));
            if (basket.get(product) == 1){
                basket.remove(product);
            }else {
                basket.put(product, basket.get(product) - 1);
            }
            session.setAttribute(ATTRIBUTE_SESSION, Collections.unmodifiableMap(basket));

            String redirect = "product.do?id=" + String.valueOf(id);
            resp.sendRedirect(redirect);
        } catch (ItemNotFoundException e) {
            System.out.println(e);
        }



    }
}
