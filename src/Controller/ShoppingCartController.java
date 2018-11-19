package Controller;

import DAO.ProductDAO;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShoppingCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Product> allProduct = productDAO.selectAll();
        req.setAttribute("allProduct", allProduct);
        req.getRequestDispatcher("allProduct.jsp").forward(req, resp);
    }
}
