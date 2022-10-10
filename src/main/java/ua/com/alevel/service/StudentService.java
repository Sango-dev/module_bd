package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.model.Student;

import java.util.List;

public class StudentService {
    private static StudentService instance;
    private static StudentDao repository;

    private StudentService() {
        repository = StudentDao.getInstance();
    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }

        return instance;
    }

    public List<Student> getStudentsWithAvgMarkGreatThan(double mark) {
        return repository.getStudentsWithAvgMarkGreatThan(mark);
    }
}
