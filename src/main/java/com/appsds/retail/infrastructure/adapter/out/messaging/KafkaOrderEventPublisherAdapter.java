package com.appsds.retail.infrastructure.adapter.out.messaging;

import com.appsds.retail.domain.event.OrderCreatedEvent;
import com.appsds.retail.domain.ports.out.OrderEventPublisherPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Secondary adapter that implements the messaging output port.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaOrderEventPublisherAdapter implements OrderEventPublisherPort {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Value("${retail.kafka.topics.order-created:order-created-events}")
  private String topicName;

  @Override
  public void publish(OrderCreatedEvent event) {
    log.info("Publishing OrderCreatedEvent for order: {}", event.orderId());

    kafkaTemplate.send(topicName, event.orderId().toString(), event);
  }
}