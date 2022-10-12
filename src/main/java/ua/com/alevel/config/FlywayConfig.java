package ua.com.alevel.config;

import org.flywaydb.core.Flyway;

public final class FlywayConfig {
    private static final String URL = "jdbc:postgresql://ec2-44-207-133-100.compute-1.amazonaws.com:5432/dd2ltcgac31gsl";
    private static final String USER = "mciqrjwbgemybl";
    private static final String PASSWORD = "8f759e76e1a3e902ad0d0bc70c9c3db1b3da43c9c9fd9426a9c6bfedefa63c55";
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
