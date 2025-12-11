package com.appsds.retail.infrastructure.adapter;

import com.appsds.retail.domain.model.Order;
import com.appsds.retail.domain.ports.out.OrderRepositoryPort;
import com.appsds.retail.infrastructure.adapter.entity.OrderEntity;
import com.appsds.retail.infrastructure.adapter.mapper.OrderDboMapper;
import com.appsds.retail.infrastructure.adapter.repository.JpaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Persistence adapter implementing the {@link OrderRepositoryPort}.
 *
 * <p>This class acts as the implementation of the secondary adapter, orchestrating
 * the mapping between domain objects and entities, and delegating actual persistence
 * operations to the {@link JpaOrderRepository}.
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPort {

  private final JpaOrderRepository jpaOrderRepository;
  private final OrderDboMapper mapper;

  @Override
  public Order save(Order order) {
    OrderEntity entity = mapper.toEntity(order);
    OrderEntity savedEntity = jpaOrderRepository.save(entity);
    return mapper.toDomain(savedEntity);
  }
}