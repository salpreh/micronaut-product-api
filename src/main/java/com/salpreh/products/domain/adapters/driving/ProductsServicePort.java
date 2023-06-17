package com.salpreh.products.domain.adapters.driving;

import com.salpreh.products.domain.exceptions.NotFoundException;
import com.salpreh.products.domain.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductsServicePort {

  List<Product> getProducts();
  Optional<Product> getProduct(long id);
  Product createProduct(Product product);
  Product updateProduct(long id, Product product) throws NotFoundException;
  void deleteProduct(long id);

}
