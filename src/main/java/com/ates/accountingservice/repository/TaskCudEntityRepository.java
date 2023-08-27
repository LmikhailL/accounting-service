package com.ates.accountingservice.repository;

import com.ates.accountingservice.entity.TaskCudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCudEntityRepository extends JpaRepository<TaskCudEntity, Long> {

}