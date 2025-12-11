package com.appsds.retail.infrastructure.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.appsds.retail.domain.model.Order;
import com.appsds.retail.domain.ports.out.OrderRepositoryPort;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class OrderRepositoryAdapterTest {

  @Autowired
  private OrderRepositoryPort orderRepositoryPort;

  @Test
  void shouldSaveAndRetrieveOrder() {
    Order domainOrder = new Order(UUID.randomUUID(), "Test Product", 1, BigDecimal.TEN);

    Order savedOrder = orderRepositoryPort.save(domainOrder);

    assertNotNull(savedOrder);
    assertEquals(domainOrder.getId(), savedOrder.getId());
    assertEquals(domainOrder.getProduct(), savedOrder.getProduct());
  }
}