package ayana_kaldybaeva.jpa_lesson;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryHolder {
    private static EntityManagerFactory factory = null;

    public static EntityManagerFactory factory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("main");
        }
        return factory;
    }
}
