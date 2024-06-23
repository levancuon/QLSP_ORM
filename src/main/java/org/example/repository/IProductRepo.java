package org.example.repository;


import org.example.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> showList();

    void add(Product product);

    Product findById(int id);

    void remove(int id);

    void update(Product product);
}
