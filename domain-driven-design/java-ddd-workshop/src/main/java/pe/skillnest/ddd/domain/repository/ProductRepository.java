package pe.skillnest.ddd.domain.repository;

import pe.skillnest.ddd.domain.entities.Product;

public interface ProductRepository {
    void Save (Product entity);
}
