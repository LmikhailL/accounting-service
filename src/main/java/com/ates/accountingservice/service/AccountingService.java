package com.ates.accountingservice.service;

import com.ates.accountingservice.entity.AccountEntity;
import com.ates.accountingservice.entity.AuditLogItemEntity;
import com.avro.events.streaming.UserSavedEvent;
import java.math.BigDecimal;
import org.apache.kafka.common.protocol.types.Field.Str;

public interface AccountingService {

  void on(UserSavedEvent event);

  void attachAuditLogItem(AuditLogItemEntity saved, String userId);

  void increaseBalance(BigDecimal by, AccountEntity account);
}
