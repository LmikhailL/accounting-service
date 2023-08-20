package com.ates.accountingservice.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InvoiceScheduler {

  @Scheduled(cron = "EACH DAY AT 18_01 PM")
  public void prepareInvoiceDataAndEmailIt() {
    // no time for implementation

    // this scheduler will take all positive account balances
    // and send this data by email to each user(email contains in the UserCudEntity)
  }
}
