package org.example.service;


import org.example.model.Product;
import org.example.repository.ProductRepo;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> showList() {
        return productRepo.showList();
    }

    @Override
    public void add(Product product) {
        productRepo.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void remove(int id) {
        productRepo.remove(id);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }
}
