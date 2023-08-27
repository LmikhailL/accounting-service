package com.ates.accountingservice.repository;

import com.ates.accountingservice.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {

  AccountEntity findByUserCudEntity_UserKeycloakId(String userKeycloakId);
}