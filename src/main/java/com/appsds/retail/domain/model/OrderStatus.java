package com.appsds.retail.domain.model;

/**
 * Defines the possible lifecycle states of a {@link Order}.
 */
public enum OrderStatus {
  /** The order has been created but not yet processed. */
  PENDING,
  /** The order has been successfully completed. */
  PROCESSED,
  /** The order was cancelled before processing. */
  CANCELLED
}
