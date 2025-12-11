package com.appsds.retail.infrastructure.adapter.in.web.dto;

import java.util.UUID;

/**
 * DTO representing the public response after an order is created.
 *
 * <p>We expose only what the client needs, hiding internal domain details.
 *
 * @param id     The unique ID of the created order.
 * @param status The current status of the order.
 */
public record OrderResponse(
    UUID id,
    String status
) {}