package org.wrabz.com.project_with_security.service;

import org.springframework.stereotype.Service;
import org.wrabz.com.project_with_security.model.Product;
import org.wrabz.com.project_with_security.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
