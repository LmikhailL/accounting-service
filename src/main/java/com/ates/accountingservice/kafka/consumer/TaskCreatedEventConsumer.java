package com.ates.accountingservice.kafka.consumer;

import static com.ates.accountingservice.utils.MdcUtils.CORRELATION_ID;
import static com.ates.accountingservice.utils.MdcUtils.setCorrelationId;

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

    //someService.on(event);

    //will create new task cud entity and wire it with account using userId
    //will create audit log item entity
    //task was assigned to the user on creation, so we will store data
    //related to the amount of money to charge + we will decrease account balance

    //need to implement producer of AuditLogItemCreated (no time for this)
  }
}
