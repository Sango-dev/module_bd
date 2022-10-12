package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import ua.com.alevel.model.Group;
import ua.com.alevel.model.SDObject;

import javax.persistence.EntityManager;
import java.util.*;

public class GroupDao {
    private static final EntityManager MANAGER = JPAConfig.getEntityManager();
    private static GroupDao instance;

    private GroupDao() {
    }

    public static GroupDao getInstance() {
        if (instance == null) {
            instance = new GroupDao();
        }

        return instance;
    }

    public List<Group> searchGroupsUsingName(String groupName) {
        List<Group> list = MANAGER.createQuery("from Group as gr where gr.name like :groupName", Group.class)
                .setParameter("groupName", "%" + groupName + "%")
                .getResultList();

        return (list.isEmpty()) ? Collections.emptyList() : list;
    }

    public List<Group> returnAllGroups() {
        List<Group> list = MANAGER.createQuery("from Group", Group.class).getResultList();
        return (list.isEmpty()) ? Collections.emptyList() : list;
    }

    public Map<String, Double> getAverageMarkOfEveryGroup() {
        Map<String, Double> map = new HashMap<>();
        List<SDObject> list = MANAGER.createQuery("SELECT NEW ua.com.alevel.model.SDObject(g.name, avg(m.mark)) from Mark as m, Student as s, Group as g where m.student = s.id and s.group = g.id group by g.id", SDObject.class).getResultList();
        list.forEach(el -> map.put(el.name(), el.mark()));
        return (map.isEmpty()) ? Collections.emptyMap() : map;
    }
}
