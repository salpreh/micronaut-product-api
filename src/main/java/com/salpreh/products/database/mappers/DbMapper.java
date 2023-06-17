package com.salpreh.products.database.mappers;

import com.salpreh.products.database.models.ProductMO;
import com.salpreh.products.domain.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface DbMapper {

  ProductMO map(Product src);
  Product map(ProductMO src);
}
