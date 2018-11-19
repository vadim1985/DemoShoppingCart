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

public class AddProductInBasket extends HttpServlet {
    private static final String ATTRIBUTE_SESSION = "AllProductInBasket";
    ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<Product, Integer> productInBasket = null;
        int id = Integer.valueOf(req.getParameter("id"));
        try {
            Product product = productDAO.selectById(id);
            HttpSession session = req.getSession();
            productInBasket = (Map<Product, Integer>)session.getAttribute(ATTRIBUTE_SESSION);
            if (productInBasket == null){
                session.setAttribute(ATTRIBUTE_SESSION, Collections.singletonMap(product, 1));
            }else {
                Map<Product, Integer> newProductInBasket = new LinkedHashMap<>(productInBasket);
                if (!newProductInBasket.containsKey(product)){
                    newProductInBasket.put(product, 1);
                }else {
                    newProductInBasket.put(product, newProductInBasket.get(product) + 1);
                }
                session.setAttribute(ATTRIBUTE_SESSION, Collections.unmodifiableMap(newProductInBasket));
            }
            String redirect = "product.do?id=" + String.valueOf(id);
            resp.sendRedirect(redirect);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }
}
