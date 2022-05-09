package za.co.neildutoit.data.ro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.neildutoit.data.domain.User;

/**
 * Queries with expensive joins and filtering goes in this repository to get executed against the read-only slave database
 */
public interface UserRepositoryRO extends JpaRepository<User, Integer> {

  @Query(
          //Just an example, this can have multiple joins and filtering to find the correct user
          value = "SELECT u.* FROM USERS u",
          nativeQuery = true)
  User longRunningQuery();
}
