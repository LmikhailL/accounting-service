package com.ates.accountingservice.repository;

import com.ates.accountingservice.entity.UserCudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCudEntityRepository extends JpaRepository<UserCudEntity, Long> {

}