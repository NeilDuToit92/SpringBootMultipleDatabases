# SpringBootMultipleDatabases
Example project showing how to configure multiple database in Spring Boot using shared entities and seperate repositories for use in a master-slave configuration.

# Scenario
A high-volume transactional service on a self-hosted database that executes long-running lookups and filtering on a complex dataset slows down the database to a point  where it affects writes and therefore response times.

# Solution
Execute time-sensitive real-time transactions against the master, whilst expensive lookups are executed on the slave, where we don't care about response times too much, allowing it to catch up to master when lookups complete.
