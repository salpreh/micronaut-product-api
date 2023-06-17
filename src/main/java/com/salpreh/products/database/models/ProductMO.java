package com.salpreh.products.database.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "product")
public class ProductMO {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
  @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
  private Long id;

  private String name;
  private String description;
  private double price;
  private int stock;
  private String imageUrl;
}
