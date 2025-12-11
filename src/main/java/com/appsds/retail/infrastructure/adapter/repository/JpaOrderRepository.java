package com.appsds.retail.infrastructure.adapter.repository;

import com.appsds.retail.infrastructure.adapter.entity.OrderEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for direct database operations on {@link OrderEntity}.
 *
 * <p>Provides standard CRUD capabilities without boilerplate code.
 */
@Repository
public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {

}