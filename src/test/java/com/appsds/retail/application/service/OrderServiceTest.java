package com.appsds.retail.application.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.appsds.retail.domain.event.OrderCreatedEvent;
import com.appsds.retail.domain.model.Order;
import com.appsds.retail.domain.ports.out.OrderEventPublisherPort;
import com.appsds.retail.domain.ports.out.OrderRepositoryPort;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

  @Mock
  private OrderRepositoryPort orderRepository;

  @Mock
  private OrderEventPublisherPort eventPublisher;

  @InjectMocks
  private OrderService orderService;

  @Test
  void shouldCreateAndSaveOrderAndPublishEvent() {
    String product = "Jeans Slim Fit";
    int quantity = 1;
    BigDecimal price = new BigDecimal("29.95");

    when(orderRepository.save(any(Order.class))).thenAnswer(i -> i.<Order>getArgument(0));

    Order result = orderService.createOrder(product, quantity, price);

    assertNotNull(result);

    verify(orderRepository).save(any(Order.class));

    verify(eventPublisher).publish(any(OrderCreatedEvent.class));
  }
}