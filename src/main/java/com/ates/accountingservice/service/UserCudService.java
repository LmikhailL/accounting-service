package com.ates.accountingservice.service;

import com.ates.accountingservice.entity.UserCudEntity;
import com.avro.events.streaming.UserSavedEvent;

public interface UserCudService {

  UserCudEntity createFrom(UserSavedEvent event);
}
