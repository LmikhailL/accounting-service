package com.ates.accountingservice.kafka.consumer;

import static com.ates.accountingservice.utils.MdcUtils.CORRELATION_ID;
import static com.ates.accountingservice.utils.MdcUtils.setCorrelationId;

import com.ates.accountingservice.service.AuditLogItemService;
import com.avro.events.streaming.TaskCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskCreatedEventConsumer {

  private final AuditLogItemService auditLogItemService;

  @KafkaListener(
      topics = "${spring.kafka.topics.task-created-topic}",
      groupId = "${spring.kafka.consumer.group-id}"
  )
  public void consume(
      @Payload TaskCreatedEvent event,
      @Header(CORRELATION_ID) String customHeader
  ) {
    setCorrelationId(customHeader);
    log.info("Received TaskCreatedEvent: {}", event);

    auditLogItemService.on(event);
  }
}
