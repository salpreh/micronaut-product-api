package com.salpreh.products.domain.adapters.driven;

import com.salpreh.products.domain.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDatasourcePort {
  List<Product> findAll();
  Optional<Product> findById(long id);

  Product save(Product product);
  void deleteById(long id);
}
