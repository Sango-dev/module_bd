package ua.com.alevel.command;

import ua.com.alevel.model.Teacher;
import ua.com.alevel.service.TeacherService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class SearchTeacher implements ICommand {
    private static final TeacherService SERVICE = TeacherService.getInstance();
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute() {
        try {
            System.out.print("\nteacher's name -> ");
            String name = READER.readLine();
            List<Teacher> list = SERVICE.searchTeacherByFLName(name);

            if (list.isEmpty()) {
                System.out.println("Teachers are not existing with this name : " + name);
                return;
            }

            list.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
