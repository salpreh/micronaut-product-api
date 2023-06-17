package com.salpreh.products.database.adapters;

import com.salpreh.products.database.mappers.DbMapper;
import com.salpreh.products.database.repositories.ProductRepository;
import com.salpreh.products.domain.adapters.driven.ProductDatasourcePort;
import com.salpreh.products.domain.models.Product;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ProductDatasourceAdapter implements ProductDatasourcePort {

  private final ProductRepository productRepository;
  private final DbMapper mapper;

  @Override
  @ReadOnly
  public List<Product> findAll() {
    return productRepository.findAll()
        .stream()
        .map(mapper::map)
        .toList();
  }

  @Override
  @ReadOnly
  public Optional<Product> findById(long id) {
    return productRepository.findById(id)
        .map(mapper::map);
  }

  @Override
  @Transactional
  public Product save(Product product) {
     var productData = mapper.map(product);

     return mapper.map(productRepository.save(productData));
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    productRepository.deleteById(id);
  }
}
