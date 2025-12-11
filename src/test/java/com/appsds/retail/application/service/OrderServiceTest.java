package com.appsds.retail.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.appsds.retail.domain.model.Order;
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

  @InjectMocks
  private OrderService orderService;

  @Test
  void shouldCreateAndSaveOrder() {
    String product = "Jeans Slim Fit";
    int quantity = 1;
    BigDecimal price = new BigDecimal("29.95");

    when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

    Order result = orderService.createOrder(product, quantity, price);

    assertNotNull(result);
    assertEquals(product, result.getProduct());
    verify(orderRepository).save(any(Order.class));
  }
}