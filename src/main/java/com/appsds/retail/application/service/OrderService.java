package com.appsds.retail.application.service;

import com.appsds.retail.domain.event.OrderCreatedEvent;
import com.appsds.retail.domain.model.Order;
import com.appsds.retail.domain.ports.in.CreateOrderUseCase;
import com.appsds.retail.domain.ports.out.OrderEventPublisherPort;
import com.appsds.retail.domain.ports.out.OrderRepositoryPort;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Application Service that orchestrates the "Create Order" use case.
 */
@Service
@RequiredArgsConstructor
public class OrderService implements CreateOrderUseCase {

  private final OrderRepositoryPort orderRepository;

  private final OrderEventPublisherPort eventPublisher;

  @Override
  @Transactional
  public Order createOrder(String product, int quantity, BigDecimal price) {

    Order order = new Order(UUID.randomUUID(), product, quantity, price);

    Order savedOrder = orderRepository.save(order);

    eventPublisher.publish(new OrderCreatedEvent(savedOrder.getId()));

    return savedOrder;
  }
}