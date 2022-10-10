package ua.com.alevel.config;

import org.flywaydb.core.Flyway;

public final class FlywayConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/University";
    private static final String USER = "postgres";
    private static final String PASSWORD = "rootroot";
    private static final String SCHEMA = "public";
    private static final String LOCATION = "db/migration";

    private FlywayConfig() {
    }

    public static void initialize() {
        JPAConfig.getEntityManager();
        Flyway flyway = Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .baselineOnMigrate(true)
                .schemas(SCHEMA)
                .locations(LOCATION)
                .load();
        flyway.migrate();
    }
}
