package com.ates.accountingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

  @GetMapping
  Object getMyAccount() {
    //No time to implement this endpoint, it will work as it was mentioned in the requirements

    /*
    У каждого из сотрудников должен быть свой счёт,
    который показывает, сколько за сегодня он получил денег.
    У счёта должен быть аудитлог того, за что были списаны
    или начислены деньги, с подробным описанием каждой из задач
     */

    return null;
  }

  @GetMapping("/statistics")
  Object getOverallStatistics() {
    //No time to implement this endpoint, it will work as it was mentioned in the requirements

    /*
    (sum(completed task amount) + sum(assigned task fee)) * -1
    У админов и бухгалтеров должен быть доступ к общей статистике по заработанным деньгам
     */

    return null;
  }

}
