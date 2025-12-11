package com.appsds.retail.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class OrderTest {
  @Test
  void shouldCreateOrderSuccessfully() {

    UUID id = UUID.randomUUID();
    String product = "Camiseta Basic";
    int quantity = 2;
    BigDecimal price = new BigDecimal("19.99");

    Order order = new Order(id, product, quantity, price);

    assertNotNull(order);
    assertEquals(OrderStatus.PENDING, order.getStatus());
    assertEquals(id, order.getId());
  }

  @Test
  void shouldThrowExceptionWhenQuantityIsZeroOrNegative() {
    assertThrows(IllegalArgumentException.class, () -> new Order(UUID.randomUUID(), "Producto", 0, BigDecimal.TEN));

    assertThrows(IllegalArgumentException.class, () -> new Order(UUID.randomUUID(), "Producto", -1, BigDecimal.TEN));
  }

  @Test
  void shouldChangeStatusToProcessedWhenCompleted() {
    Order order = new Order(UUID.randomUUID(), "Camiseta", 1, BigDecimal.TEN);

    order.complete();

    assertEquals(OrderStatus.PROCESSED, order.getStatus());
  }

  @Test
  void shouldThrowExceptionWhenCompletingNonPendingOrder() {
    Order order = new Order(UUID.randomUUID(), "Camiseta", 1, BigDecimal.TEN);
    order.complete();

    assertThrows(IllegalStateException.class, order::complete);
  }
}
