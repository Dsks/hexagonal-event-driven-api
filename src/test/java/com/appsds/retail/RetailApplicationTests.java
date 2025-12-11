package com.appsds.retail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.appsds.retail.domain.ports.out.OrderRepositoryPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class RetailApplicationTests {

    @MockitoBean
    private OrderRepositoryPort orderRepositoryPort;

    @Test
    void contextLoads() {
        assertTrue(true, "Context loaded successfully");
    }

}
