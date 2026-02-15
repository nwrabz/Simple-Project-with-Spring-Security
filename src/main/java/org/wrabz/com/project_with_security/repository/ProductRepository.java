package org.wrabz.com.project_with_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wrabz.com.project_with_security.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
