package com.appsds.retail.infrastructure.adapter.entity;

import com.appsds.retail.domain.model.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JPA Entity representing the persistent state of an Order.
 *
 * <p>This class maps directly to the "orders" table in the database.
 * It is distinct from the Domain Entity to decouple the database schema
 * from business logic.
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

  @Id
  private UUID id;

  private String product;

  private int quantity;

  private BigDecimal price;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

}