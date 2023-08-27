package com.ates.accountingservice.service.impl;

import com.ates.accountingservice.entity.AuditLogItemEntity;
import com.ates.accountingservice.entity.TaskCudEntity;
import com.ates.accountingservice.repository.AuditLogItemEntityRepository;
import com.ates.accountingservice.service.AccountingService;
import com.ates.accountingservice.service.AuditLogItemService;
import com.ates.accountingservice.service.TaskService;
import com.avro.events.streaming.TaskCreatedEvent;
import com.avro.events.streaming.TaskUpdatedEvent;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuditLogItemServiceImpl implements AuditLogItemService {

  private final TaskService taskService;
  private final AuditLogItemEntityRepository repository;
  private final AccountingService accountingService;

  @Override
  @Transactional
  public void on(TaskCreatedEvent event) {
    AuditLogItemEntity auditLogItem = new AuditLogItemEntity();
    auditLogItem.setCreatedAt(LocalDateTime.now());
    auditLogItem.setIsPayed(false);
    auditLogItem.setTaskCudEntity(taskService.createFrom(event));

    AuditLogItemEntity saved = repository.save(auditLogItem);
    accountingService.attachAuditLogItem(saved, event.getUserId());
  }

  @Override
  @Transactional
  public void on(TaskUpdatedEvent event) {
    AuditLogItemEntity toUpdate = repository.findByTaskCudEntity_Id(event.getId());
    TaskCudEntity updatedTask = taskService.on(event);
    accountingService.increaseBalance(
        updatedTask.getAmountOfMoneyToPay(),
        toUpdate.getAccountEntity()
    );
  }
}
