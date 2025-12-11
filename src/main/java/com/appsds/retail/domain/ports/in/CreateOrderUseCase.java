package com.appsds.retail.domain.ports.in;

import com.appsds.retail.domain.model.Order;
import java.math.BigDecimal;

/**
 * Input port defining the "Create Order" use case.
 */
public interface CreateOrderUseCase {

  /**
   * Creates a new order in the system.
   *
   * @param product  The product identifier.
   * @param quantity The quantity (must be > 0).
   * @param price    The unit price.
   * @return The created Order with its ID generated.
   */
  Order createOrder(String product, int quantity, BigDecimal price);

}