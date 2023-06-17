package com.salpreh.products.restapi.controllers;

import com.salpreh.products.domain.adapters.driving.ProductsServicePort;
import com.salpreh.products.restapi.mappers.ApiMapper;
import com.salpreh.products.restapi.models.ProductDto;
import com.salpreh.products.restapi.models.UpsertProductDto;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.exceptions.HttpStatusException;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Controller("/products")
@RequiredArgsConstructor
public class ProductsController {

  private final ProductsServicePort productsService;
  private final ApiMapper mapper;

  @Get
  public List<ProductDto> getProducts() {
    return productsService.getProducts()
      .stream()
      .map(mapper::map)
      .toList();
  }

  @Get("{id}")
  public ProductDto getProduct(@PathVariable long id) {
    return productsService.getProduct(id)
      .map(mapper::map)
      .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "Product not found"));
  }

  @Post
  public ProductDto createProduct(@Body UpsertProductDto createRequest) {
    var product = mapper.map(createRequest);

    return mapper.map(productsService.createProduct(product));
  }

  @Put("{id}")
  public ProductDto updateProduct(@PathVariable long id, @Body UpsertProductDto updateRequest) {
    var product = mapper.map(updateRequest);

    return mapper.map(productsService.updateProduct(id, product));
  }

  @Delete("{id}")
  public void deleteProduct(@PathVariable long id) {
    productsService.deleteProduct(id);
  }
}
