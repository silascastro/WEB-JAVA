package sil.looja.loja.products.repository;

import org.springframework.data.repository.CrudRepository;
import sil.looja.loja.products.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
