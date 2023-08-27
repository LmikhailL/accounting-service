package com.ates.accountingservice.service;

import com.ates.accountingservice.entity.TaskCudEntity;
import com.avro.events.streaming.TaskCreatedEvent;

public interface TaskService {

  TaskCudEntity createFrom(TaskCreatedEvent event);

  TaskCudEntity on(com.avro.events.streaming.TaskUpdatedEvent event);
}
