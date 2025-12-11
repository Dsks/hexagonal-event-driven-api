package com.appsds.retail.infrastructure.adapter.in.web;

import com.appsds.retail.domain.model.Order;
import com.appsds.retail.domain.ports.in.CreateOrderUseCase;
import com.appsds.retail.infrastructure.adapter.in.web.dto.CreateOrderRequest;
import com.appsds.retail.infrastructure.adapter.in.web.dto.OrderResponse;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller acting as the Driving Adapter.
 *
 * <p>Exposes HTTP endpoints and translates HTTP requests into Domain Use Cases.
 */
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

  private final CreateOrderUseCase createOrderUseCase;

  /**
   * Endpoint to create a new order.
   *
   * @param request The valid JSON request body.
   * @return 201 Created with the Location header and the Order response.
   */
  @PostMapping
  public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
    // 1. Call the Input Port (Use Case)
    Order createdOrder = createOrderUseCase.createOrder(
        request.product(),
        request.quantity(),
        request.price()
    );

    // 2. Map Domain -> Response DTO
    OrderResponse response = new OrderResponse(
        createdOrder.getId(),
        createdOrder.getStatus().name()
    );

    // 3. Build HTTP 201 Response
    return ResponseEntity
        .created(URI.create("/orders/" + response.id()))
        .body(response);
  }
}