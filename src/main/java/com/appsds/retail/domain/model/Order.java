package com.appsds.retail.domain.model;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a core domain entity for a Retail Order.
 *
 * <p>This class encapsulates the business rules and state transitions
 * related to an order. It guarantees that an order is always created
 * in a valid state and manages its lifecycle.
 */
@Getter
@ToString
public class Order {

  private final UUID id;
  private final String product;
  private final int quantity;
  private final BigDecimal price;
  private OrderStatus status;

  /**
   * Creates a new Order with the initial state set to PENDING.
   *
   * @param id       The unique identifier of the order.
   * @param product  The name or identifier of the product.
   * @param quantity The number of items ordered (must be greater than zero).
   * @param price    The unit price of the product.
   * @throws IllegalArgumentException if the quantity is zero or negative.
   */
  public Order(UUID id, String product, int quantity, BigDecimal price) {
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity must be greater than zero");
    }
    this.id = id;
    this.product = product;
    this.quantity = quantity;
    this.price = price;
    this.status = OrderStatus.PENDING;
  }

  /**
   * Transitions the order state from PENDING to PROCESSED.
   *
   * <p>This is a domain business action that validates the transition.
   *
   * @throws IllegalStateException if the order is not currently in PENDING state.
   */
  public void complete() {
    if (this.status != OrderStatus.PENDING) {
      throw new IllegalStateException("Order cannot be completed unless it is PENDING");
    }
    this.status = OrderStatus.PROCESSED;
  }

}