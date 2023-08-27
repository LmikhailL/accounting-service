package com.ates.accountingservice.service;

import com.avro.events.streaming.TaskCreatedEvent;

public interface AuditLogItemService {

  void on(TaskCreatedEvent event);

  void on(com.avro.events.streaming.TaskUpdatedEvent event);
}
