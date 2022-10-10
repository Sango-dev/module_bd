package ua.com.alevel.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JPAConfig {
    private static EntityManager entityManager;

    private JPAConfig() {
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = Persistence.
                    createEntityManagerFactory("persistence").
                    createEntityManager();
        }

        return entityManager;
    }
}
