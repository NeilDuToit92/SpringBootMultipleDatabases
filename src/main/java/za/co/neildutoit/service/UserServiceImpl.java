package za.co.neildutoit.service;

import org.springframework.stereotype.Service;
import za.co.neildutoit.data.ro.repo.UserRepositoryRO;
import za.co.neildutoit.data.rw.repo.UserRepositoryRW;

@Service
public class UserServiceImpl implements UserService {

  //Master database repository
  private final UserRepositoryRW userRepositoryRW;

  //Slave database repository
  private final UserRepositoryRO userRepositoryRO;

  public UserServiceImpl(UserRepositoryRW userRepositoryRW, UserRepositoryRO userRepositoryRO) {
    this.userRepositoryRW = userRepositoryRW;
    this.userRepositoryRO = userRepositoryRO;
  }

  @Override
  public String executeFastTransaction() {
    return userRepositoryRW.findAll().toString();
  }

  @Override
  public String executeSlowTransaction() {
    return userRepositoryRO.longRunningQuery().toString();
  }
}
