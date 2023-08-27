package com.ates.accountingservice.repository;

import com.ates.accountingservice.entity.AuditLogItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogItemEntityRepository extends JpaRepository<AuditLogItemEntity, Long> {

  AuditLogItemEntity findByTaskCudEntity_Id(Long id);
}