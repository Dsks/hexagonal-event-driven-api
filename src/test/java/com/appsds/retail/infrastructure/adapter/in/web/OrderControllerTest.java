package com.appsds.retail.infrastructure.adapter.in.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.appsds.retail.domain.model.Order;
import com.appsds.retail.domain.ports.in.CreateOrderUseCase;
import com.appsds.retail.infrastructure.adapter.in.web.dto.CreateOrderRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @MockitoBean
  private CreateOrderUseCase createOrderUseCase;

  @Test
  void shouldCreateOrderSuccessfully() throws Exception {

    CreateOrderRequest request = new CreateOrderRequest("Camiseta", 2, new BigDecimal("19.99"));

    Order domainOrder = new Order(UUID.randomUUID(), "Camiseta", 2, new BigDecimal("19.99"));

    when(createOrderUseCase.createOrder(any(), anyInt(), any())).thenReturn(domainOrder);

    mockMvc.perform(post("/orders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isCreated()) // Esperamos un 201 Created
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.status").value("PENDING"));
  }
}