package ua.com.alevel.service;

import ua.com.alevel.dao.SubjectDao;

public class SubjectService {
    private static SubjectService instance;
    private static SubjectDao repository;

    private SubjectService() {
        repository = SubjectDao.getInstance();
    }

    public static SubjectService getInstance() {
        if (instance == null) {
            instance = new SubjectService();
        }

        return instance;
    }

    public void getSubjectsPerformance() {
        repository.getSubjectsPerformance();
    }
}
