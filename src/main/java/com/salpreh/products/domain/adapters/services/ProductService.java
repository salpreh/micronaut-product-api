package com.salpreh.products.domain.adapters.services;

import com.salpreh.products.domain.adapters.driven.ProductDatasourcePort;
import com.salpreh.products.domain.adapters.driving.ProductsServicePort;
import com.salpreh.products.domain.exceptions.NotFoundException;
import com.salpreh.products.domain.models.Product;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ProductService implements ProductsServicePort {

  private final ProductDatasourcePort productDatasourcePort;

  @Override
  public List<Product> getProducts() {
    return productDatasourcePort.findAll();
  }

  @Override
  public Optional<Product> getProduct(long id) {
    return productDatasourcePort.findById(id);
  }

  @Override
  public Product createProduct(Product product) {
    return productDatasourcePort.save(product);
  }

  @Override
  public Product updateProduct(long id, Product product) throws NotFoundException {
    product.setId(id);

    return productDatasourcePort.save(product);
  }

  @Override
  public void deleteProduct(long id) {
    productDatasourcePort.deleteById(id);
  }
}
