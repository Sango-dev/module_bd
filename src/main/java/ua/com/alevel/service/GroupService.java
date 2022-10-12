package ua.com.alevel.service;

import ua.com.alevel.dao.GroupDao;
import ua.com.alevel.model.Group;

import java.util.List;
import java.util.Map;

public class GroupService {
    private static GroupService instance;
    private static GroupDao repository;

    private GroupService() {
        repository = GroupDao.getInstance();
    }

    public static GroupService getInstance() {
        if (instance == null) {
            instance = new GroupService();
        }

        return instance;
    }

    public List<Group> searchGroupsUsingName(String groupName) {
        if (groupName == null) {
            throw new IllegalArgumentException("Group's name must not be null!");
        }

        return repository.searchGroupsUsingName(groupName);
    }

    public List<Group> returnAllGroups() {
        return repository.returnAllGroups();
    }

    public Map<String, Double> getAverageMarkOfEveryGroup() {
        return repository.getAverageMarkOfEveryGroup();
    }
}
