package za.co.neildutoit.data.rw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.neildutoit.data.domain.User;

/**
 * Basic inserts and reads that require performance happen in this repository and executes against the master database
 */
@Repository
public interface UserRepositoryRW extends JpaRepository<User, Integer> {
}
