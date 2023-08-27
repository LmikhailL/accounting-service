package com.ates.accountingservice.entity;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "audit_log_item_entity")
public class AuditLogItemEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "is_payed")
  private Boolean isPayed;

  @OneToOne(cascade = ALL, optional = false)
  @JoinColumn(name = "task_cud_entity_id")
  private TaskCudEntity taskCudEntity;

  @ManyToOne
  @JoinColumn(name = "account_entity_id")
  private AccountEntity accountEntity;
}