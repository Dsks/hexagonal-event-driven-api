package com.appsds.retail.application.service;

import com.appsds.retail.domain.event.OrderCreatedEvent;
import com.appsds.retail.domain.ports.in.ProcessOrderCreatedUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Application Service that handles the business logic triggered when an order is created.
 *
 * <p>This service implements the {@link ProcessOrderCreatedUseCase} input port.
 * It is invoked by the driving adapter (e.g., Kafka Listener) asynchronously.
 * Its responsibility is to execute side effects or downstream processes required
 * after an order is persisted, such as stock reservation, fraud check, or shipping.
 */
@Slf4j
@Service
public class OrderProcessingService implements ProcessOrderCreatedUseCase {

  /**
   * Processes the domain event indicating a new order has been created.
   *
   * @param event The event containing the order ID and timestamp.
   */
  @Override
  public void handleOrderCreated(OrderCreatedEvent event) {
    log.info("DOMAIN LOGIC EXECUTED: Processing order {}", event.orderId());
  }
}