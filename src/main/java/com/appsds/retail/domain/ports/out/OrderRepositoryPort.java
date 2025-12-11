package com.appsds.retail.domain.ports.out;

import com.appsds.retail.domain.model.Order;

/**
 * Output port for Order persistence operations.
 */
public interface OrderRepositoryPort {

  Order save(Order order);

}