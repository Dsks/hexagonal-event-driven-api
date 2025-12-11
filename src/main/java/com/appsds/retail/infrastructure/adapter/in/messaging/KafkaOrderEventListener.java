package com.appsds.retail.infrastructure.adapter.in.messaging;

import com.appsds.retail.domain.event.OrderCreatedEvent;
import com.appsds.retail.domain.ports.in.ProcessOrderCreatedUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Driving Adapter that listens to Kafka topics.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaOrderEventListener {

  private final ProcessOrderCreatedUseCase processOrderCreatedUseCase;

  /**
   * Listens to the 'order-created' topic.
   *
   * @param event The deserialized event payload.
   */
  @KafkaListener(
      topics = "${retail.kafka.topics.order-created:order-created-events}",
      groupId = "${spring.application.name:retail-group}"
  )
  public void listen(OrderCreatedEvent event) {
    log.info("Received OrderCreatedEvent from Kafka: {}", event.orderId());
    processOrderCreatedUseCase.handleOrderCreated(event);
  }
}