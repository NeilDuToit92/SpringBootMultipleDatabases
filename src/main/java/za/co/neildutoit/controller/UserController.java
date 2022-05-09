package za.co.neildutoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.neildutoit.service.UserService;

@RestController
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/fast")
  public String executeFastTransaction() {
    return userService.executeFastTransaction();
  }

  @RequestMapping("/slow")
  public String executeSlowTransaction() {
    return userService.executeSlowTransaction();
  }
}
