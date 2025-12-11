package com.appsds.retail.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Domain Event representing the successful creation of an order.
 */
public record OrderCreatedEvent(
    UUID orderId,
    LocalDateTime occurredOn
) {
  public OrderCreatedEvent(UUID orderId) {
    this(orderId, LocalDateTime.now());
  }
}