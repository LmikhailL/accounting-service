package com.ates.accountingservice.kafka.consumer;

import static com.ates.accountingservice.utils.MdcUtils.CORRELATION_ID;
import static com.ates.accountingservice.utils.MdcUtils.setCorrelationId;

import com.avro.events.streaming.UserSavedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserSavedEventConsumer {

  @KafkaListener(
      topics = "${spring.kafka.topics.user-saved-topic}",
      groupId = "${spring.kafka.consumer.group-id}"
  )
  public void consume(
      @Payload UserSavedEvent event,
      @Header(CORRELATION_ID) String customHeader
  ) {
    setCorrelationId(customHeader);
    log.info("Received UserSavedEvent: {}", event);

    //accountFacade.on(event);

    //will create new account with empty balance for newly created user
    //will create user cud entity and wire it with account entity

    //need to implement producer of AccountCreatedEvent (no time for this)
  }
}
