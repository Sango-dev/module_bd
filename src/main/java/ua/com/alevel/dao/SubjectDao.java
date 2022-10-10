package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import ua.com.alevel.model.SDObject;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class SubjectDao {
    private static final EntityManager MANAGER = JPAConfig.getEntityManager();
    private static SubjectDao instance;

    private SubjectDao() {
    }

    public static SubjectDao getInstance() {
        if (instance == null) {
            instance = new SubjectDao();
        }

        return instance;
    }

    public void getSubjectsPerformance() {
        List<SDObject> list = MANAGER.createQuery("SELECT NEW ua.com.alevel.model.SDObject(s.name, avg(m.mark)) from Subject as s, Mark as m where m.subject = s.id group by s.id", SDObject.class).getResultList();
        Collections.sort(list);
        System.out.println("Bad performance: " + list.get(0).name() + " (avg grade = " + list.get(0).mark() + ")");
        System.out.println("Best performance: " + list.get(list.size() - 1).name() + " (avg grade = " + list.get(list.size() - 1).mark() + ")");
    }
}
