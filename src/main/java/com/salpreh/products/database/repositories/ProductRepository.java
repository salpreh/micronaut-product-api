package com.salpreh.products.database.repositories;

import com.salpreh.products.database.models.ProductMO;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  List<ProductMO> findAll();
  Optional<ProductMO> findById(long id);

  ProductMO save(ProductMO product);
  void delete(ProductMO product);
  void deleteById(long id);
}
