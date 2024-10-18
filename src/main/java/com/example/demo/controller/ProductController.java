package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;

    @QueryMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product getProductById(@Argument Long id) {
        return productService.getProduct(id);
    }

    @MutationMapping
    public Product createProduct(@Argument String name,
                                 @Argument Double price,
                                 @Argument Integer quantity,
                                 @Argument String description) {
        return productService.createProduct(name, price, quantity, description);
    }

    @MutationMapping
    public Product updateProductById(@Argument Long id,
                                     @Argument String name,
                                     @Argument Double price,
                                     @Argument Integer quantity,
                                     @Argument String description) {
        return productService.updateProduct(id, name, price, quantity, description);
    }

    @MutationMapping
    public Boolean deleteProductById(@Argument Long id) {
        return productService.deleteProduct(id);
    }
}
