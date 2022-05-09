package za.co.neildutoit.service;

public interface UserService {
  /**
   * Uses master database to execute fast query
   *
   * @return String - The query's response in String format
   */
  String executeFastTransaction();

  /**
   * Uses slave database to execute a long-running query
   *
   * @return String - The query's response in String format
   */
  String executeSlowTransaction();
}
