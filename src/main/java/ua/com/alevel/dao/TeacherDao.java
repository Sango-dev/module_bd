package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import ua.com.alevel.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class TeacherDao {
    private static final EntityManager MANAGER = JPAConfig.getEntityManager();
    private static TeacherDao instance;

    private TeacherDao() {
    }

    public static TeacherDao getInstance() {
        if (instance == null) {
            instance = new TeacherDao();
        }

        return instance;
    }

    public List<Teacher> searchTeacherByFLName(String name) {
        List<Teacher> list = MANAGER.createQuery("from Teacher as t where t.firstName = :fn or t.lastName = :ln")
                .setParameter("fn", name)
                .setParameter("ln", name)
                .getResultList();

        return (list.isEmpty()) ? Collections.emptyList() : list;
    }
}
