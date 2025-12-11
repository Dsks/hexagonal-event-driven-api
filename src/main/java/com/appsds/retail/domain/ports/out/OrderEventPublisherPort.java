package com.appsds.retail.domain.ports.out;

import com.appsds.retail.domain.event.OrderCreatedEvent;

/**
 * Output port for publishing domain events.
 */
public interface OrderEventPublisherPort {

  void publish(OrderCreatedEvent event);

}