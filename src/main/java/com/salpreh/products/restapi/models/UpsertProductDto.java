package com.salpreh.products.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpsertProductDto {
  private String name;
  private String description;
  private double price;
  private int stock;
  private String imageUrl;
}
