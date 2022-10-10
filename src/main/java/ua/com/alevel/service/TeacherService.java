package ua.com.alevel.service;

import ua.com.alevel.dao.TeacherDao;
import ua.com.alevel.model.Teacher;

import java.util.List;

public class TeacherService {
    private static TeacherService instance;
    private static TeacherDao repository;

    private TeacherService() {
        repository = TeacherDao.getInstance();
    }

    public static TeacherService getInstance() {
        if (instance == null) {
            instance = new TeacherService();
        }

        return instance;
    }

    public List<Teacher> searchTeacherByFLName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Teacher's name must not be null!");
        }

        return repository.searchTeacherByFLName(name);
    }
}
