package com.appsds.retail.infrastructure.adapter.mapper;

import com.appsds.retail.domain.model.Order;
import com.appsds.retail.infrastructure.adapter.entity.OrderEntity;
import org.springframework.stereotype.Component;

/**
 * Component responsible for mapping between Domain Objects and Persistence Entities.
 *
 * <p>Handles the translation of {@link Order} (Domain) to {@link OrderEntity} (Database)
 * and vice-versa, ensuring isolation between layers.
 */
@Component
public class OrderDboMapper {

  /**
   * Converts a domain model to its JPA entity representation.
   *
   * @param domain The domain order object.
   * @return The corresponding JPA entity, or null if input is null.
   */
  public OrderEntity toEntity(Order domain) {
    if (domain == null) {
      return null;
    }
    return new OrderEntity(
        domain.getId(),
        domain.getProduct(),
        domain.getQuantity(),
        domain.getPrice(),
        domain.getStatus()
    );
  }

  /**
   * Converts a JPA entity to its domain model representation.
   *
   * @param entity The JPA order entity.
   * @return The corresponding domain object, or null if input is null.
   */
  public Order toDomain(OrderEntity entity) {
    if (entity == null) {
      return null;
    }
    return new Order(
        entity.getId(),
        entity.getProduct(),
        entity.getQuantity(),
        entity.getPrice()
    );
  }
}