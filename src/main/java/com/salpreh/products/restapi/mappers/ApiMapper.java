package com.salpreh.products.restapi.mappers;

import com.salpreh.products.domain.models.Product;
import com.salpreh.products.restapi.models.UpsertProductDto;
import com.salpreh.products.restapi.models.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface ApiMapper {

  ProductDto map(Product src);
  Product map(UpsertProductDto src);

}
