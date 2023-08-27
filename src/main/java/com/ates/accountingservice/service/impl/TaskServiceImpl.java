package com.ates.accountingservice.service.impl;

import com.ates.accountingservice.entity.TaskCudEntity;
import com.ates.accountingservice.repository.TaskCudEntityRepository;
import com.ates.accountingservice.service.TaskService;
import com.avro.events.streaming.TaskCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.avro.events.streaming.TaskUpdatedEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskCudEntityRepository repository;

  @Override
  @Transactional
  public TaskCudEntity createFrom(TaskCreatedEvent event) {
    TaskCudEntity taskCud = new TaskCudEntity();
    taskCud.setId(event.getId());
    taskCud.setTitle(event.getTitle());
    taskCud.setJiraId(event.getJiraId());
    taskCud.setDescription(event.getDescription());
    taskCud.setAmountOfMoneyToCharge(event.getAmountOfMoneyToCharge());
    taskCud.setAmountOfMoneyToPay(null);

    return repository.save(taskCud);
  }

  @Override
  @Transactional
  public TaskCudEntity on(TaskUpdatedEvent event) {
    TaskCudEntity toUpdate = repository.findById(event.getId()).orElseThrow();
    toUpdate.setAmountOfMoneyToPay(event.getAmountOfMoneyToPay());
    return repository.save(toUpdate);
  }
}
