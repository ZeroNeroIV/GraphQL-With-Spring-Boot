package com.example.demo.service;

import com.example.demo.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductService {
    private static Long Counter = 0L;
    private final Map<Long, Product> products = new HashMap<>();

    public Iterable<Product> getAllProducts() {
        return products.values();
    }

    public Product getProduct(long id) {
        return products.get(id);
    }

    public Product createProduct(String name,
                                 Double price,
                                 Integer quantity,
                                 String description) {
        Product product = new Product();
        product.setId(++Counter);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescription(description);
        products.put(product.getId(), product);
        return product;
    }

    public Boolean deleteProduct(Long id) {
        if (!products.containsKey(id)) {
            return false;
        }
        products.remove(id);
        return true;
    }

    public Product updateProduct(Long id,
                                 String name,
                                 Double price,
                                 Integer quantity,
                                 String description) {
        Product product = products.get(id);
        if (product == null) {
            throw new RuntimeException("Product with id " + id + " does not exist");
        }
        if (name != null) {
            product.setName(name);
        }
        if (price != null) {
            product.setPrice(price);
        }
        if (quantity != null) {
            product.setQuantity(quantity);
        }
        if (description != null) {
            product.setDescription(description);
        }
        return products.put(product.getId(), product);
    }

}
