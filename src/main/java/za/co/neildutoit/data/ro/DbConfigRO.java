package za.co.neildutoit.data.ro;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "roEntityManagerFactory",
        transactionManagerRef = "roTransactionManager",
        basePackages = { "za.co.neildutoit.data.ro.repo" }
)
public class DbConfigRO {

  @Bean(name = "roDataSource")
  @ConfigurationProperties(prefix = "ro.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "roEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean
  barEntityManagerFactory(
          EntityManagerFactoryBuilder builder,
          @Qualifier("roDataSource") DataSource dataSource
  ) {
    return
            builder
                    .dataSource(dataSource)
                    .packages("za.co.neildutoit.data.domain")
                    .persistenceUnit("ro")
                    .build();
  }
  @Bean(name = "roTransactionManager")
  public PlatformTransactionManager roTransactionManager(
          @Qualifier("roEntityManagerFactory") EntityManagerFactory
                  roEntityManagerFactory
  ) {
    return new JpaTransactionManager(roEntityManagerFactory);
  }
}
