package DAO;

import bean.Product;
import Exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductDAO {
    private Map<Integer, Product> products = new ConcurrentHashMap<Integer, Product>();

    public ProductDAO() {
        products.put(1, new Product(1, "Sausage", 56.20));
        products.put(2, new Product(2, "Apple", 23.00));
        products.put(3, new Product(3, "Cake", 102.01));
        products.put(4, new Product(4, "Egg",2.3));
        products.put(5, new Product(5, "Beer",68.99));
    }

    public Product selectById (Integer id) throws ItemNotFoundException {
        if (!products.containsKey(id)){
            throw new ItemNotFoundException("Item with id " + id + " not found.");
        }
        return products.get(id);
    }

    public List<Product> selectAll(){
        return new ArrayList<>(products.values());
    }
}
