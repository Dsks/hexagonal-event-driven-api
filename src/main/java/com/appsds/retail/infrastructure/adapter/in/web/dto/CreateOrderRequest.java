package com.appsds.retail.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 * DTO representing the payload to create a new order.
 *
 * <p>Uses Java Records for immutability and concise syntax.
 * Includes Bean Validation annotations to ensure data integrity at the edge.
 *
 * @param product  Name of the product (cannot be blank).
 * @param quantity Number of items (must be positive).
 * @param price    Unit price (must be provided).
 */
public record CreateOrderRequest(
    @NotBlank(message = "Product cannot be blank")
    String product,

    @Positive(message = "Quantity must be greater than zero")
    int quantity,

    @NotNull(message = "Price is mandatory")
    BigDecimal price
) {}