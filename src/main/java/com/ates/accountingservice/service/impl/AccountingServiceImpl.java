package com.ates.accountingservice.service.impl;

import com.ates.accountingservice.entity.AccountEntity;
import com.ates.accountingservice.entity.AuditLogItemEntity;
import com.ates.accountingservice.repository.AccountEntityRepository;
import com.ates.accountingservice.service.AccountingService;
import com.ates.accountingservice.service.UserCudService;
import com.avro.events.streaming.UserSavedEvent;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountingServiceImpl implements AccountingService {

  private final AccountEntityRepository repository;
  private final UserCudService userCudService;

  @Override
  @Transactional
  public void on(UserSavedEvent event) {
    AccountEntity account = new AccountEntity();
    account.setBalance(new BigDecimal("0.00"));
    account.setAuditLogItems(null);
    account.setUserCudEntity(userCudService.createFrom(event));

    repository.save(account);
  }

  @Override
  @Transactional
  public void attachAuditLogItem(AuditLogItemEntity saved, String userId) {
    BigDecimal toCharge = saved.getTaskCudEntity().getAmountOfMoneyToCharge();
    AccountEntity account = repository.findByUserCudEntity_UserKeycloakId(userId);

    account.decreaseBalanceBy(toCharge);
    account.addAuditLogItemEntity(saved);
  }

  @Override
  @Transactional
  public void increaseBalance(BigDecimal by, AccountEntity account) {
    account.increaseBalanceBy(by);
    repository.save(account);
  }
}
