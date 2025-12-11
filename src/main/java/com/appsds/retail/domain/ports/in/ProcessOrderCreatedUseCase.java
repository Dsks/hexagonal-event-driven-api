package com.appsds.retail.domain.ports.in;

import com.appsds.retail.domain.event.OrderCreatedEvent;

/**
 * Input port (Use Case) triggered when an order is created externally.
 */
public interface ProcessOrderCreatedUseCase {

  void handleOrderCreated(OrderCreatedEvent event);

}