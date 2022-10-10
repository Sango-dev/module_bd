package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import ua.com.alevel.model.Student;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class StudentDao {
    private static final EntityManager MANAGER = JPAConfig.getEntityManager();
    private static StudentDao instance;

    private StudentDao() {
    }

    public static StudentDao getInstance() {
        if (instance == null) {
            instance = new StudentDao();
        }

        return instance;
    }

    public List<Student> getStudentsWithAvgMarkGreatThan(double mark) {
        List<Student> list = MANAGER.createQuery("from Student as st where (select avg(m.mark) from Mark as m where m.student = st.id) > :mark")
                .setParameter("mark", mark)
                .getResultList();

        return (list.isEmpty()) ? Collections.emptyList() : list;
    }

}
