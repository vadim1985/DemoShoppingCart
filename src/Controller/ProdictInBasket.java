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

public class ProdictInBasket extends HttpServlet {
    private static final String ATTRIBUTE_SESSION = "AllProductInBasket";
    ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        try {
            Product product = productDAO.selectById(id);
            req.setAttribute("product", product);
            req.getRequestDispatcher("shoppingCart.jsp").forward(req,resp);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }
}
