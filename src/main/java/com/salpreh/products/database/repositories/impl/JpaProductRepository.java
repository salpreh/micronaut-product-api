package com.salpreh.products.database.repositories.impl;

import com.salpreh.products.database.models.ProductMO;
import com.salpreh.products.database.repositories.ProductRepository;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class JpaProductRepository implements ProductRepository {

  private final EntityManager entityManager;

  @Override
  public List<ProductMO> findAll() {
    return entityManager.createQuery("SELECT p FROM ProductMO p", ProductMO.class)
        .getResultList();
  }

  @Override
  public Optional<ProductMO> findById(long id) {
    return Optional.ofNullable(entityManager.find(ProductMO.class, id));
  }

  @Override
  public ProductMO save(ProductMO product) {
    if (product.getId() == null) entityManager.persist(product);
    else product = entityManager.merge(product);

    return product;
  }

  @Override
  public void delete(ProductMO product) {
    entityManager.remove(product);
  }

  @Override
  public void deleteById(long id) {
    entityManager.createQuery("DELETE FROM ProductMO p WHERE p.id = :id")
        .setParameter("id", id)
        .executeUpdate();
  }

}
