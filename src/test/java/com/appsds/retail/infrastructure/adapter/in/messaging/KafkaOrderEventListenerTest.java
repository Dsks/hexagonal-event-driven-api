package com.appsds.retail.infrastructure.adapter.in.messaging;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.appsds.retail.domain.event.OrderCreatedEvent;
import com.appsds.retail.domain.ports.in.ProcessOrderCreatedUseCase;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KafkaOrderEventListenerTest {

  @Mock
  private ProcessOrderCreatedUseCase processOrderCreatedUseCase;

  @InjectMocks
  private KafkaOrderEventListener kafkaOrderEventListener;

  @Test
  void shouldCallUseCaseWhenEventReceived() {
    OrderCreatedEvent event = new OrderCreatedEvent(UUID.randomUUID());

    kafkaOrderEventListener.listen(event);

    verify(processOrderCreatedUseCase).handleOrderCreated(any(OrderCreatedEvent.class));
  }
}