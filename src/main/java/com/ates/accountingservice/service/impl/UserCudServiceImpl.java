package com.ates.accountingservice.service.impl;

import com.ates.accountingservice.entity.UserCudEntity;
import com.ates.accountingservice.repository.UserCudEntityRepository;
import com.ates.accountingservice.service.UserCudService;
import com.avro.events.streaming.UserSavedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCudServiceImpl implements UserCudService {

  private final UserCudEntityRepository repository;

  @Override
  @Transactional
  public UserCudEntity createFrom(UserSavedEvent event) {
    UserCudEntity userCud = new UserCudEntity();
    userCud.setUserKeycloakId(event.getUserKeycloakId());
    userCud.setRole(event.getRole());
    userCud.setFirstName(event.getFirstName());
    userCud.setLastName(event.getLastName());

    return repository.save(userCud);
  }
}
