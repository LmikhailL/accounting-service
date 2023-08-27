package com.ates.accountingservice.entity;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task_cud_entity")
public class TaskCudEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "amount_of_money_to_charge")
  private BigDecimal amountOfMoneyToCharge;

  @Column(name = "amount_of_money_to_pay")
  private BigDecimal amountOfMoneyToPay;

  @Column(name = "title")
  private String title;

  @Column(name = "jira_id")
  private Long jiraId;
}