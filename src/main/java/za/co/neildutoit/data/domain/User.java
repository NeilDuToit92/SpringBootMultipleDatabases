package za.co.neildutoit.data.domain;

import javax.persistence.*;

/**
 * A single entity that is shared between both repositories
 */
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
