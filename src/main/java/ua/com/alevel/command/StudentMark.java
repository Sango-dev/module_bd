package ua.com.alevel.command;

import ua.com.alevel.model.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class StudentMark implements ICommand {
    private static final StudentService SERVICE = StudentService.getInstance();
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute() {
        try {
            System.out.print("\nEnter mark -> ");
            double mark = Double.parseDouble(READER.readLine());

            if (mark < 0.0) {
                System.out.println("Invalid input!!!");
                return;
            }

            List<Student> list = SERVICE.getStudentsWithAvgMarkGreatThan(mark);

            if (list.isEmpty()) {
                System.out.println("No one!!!");
                return;
            }

            System.out.println("\nResult (avg mark > " + mark + "): ");
            list.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
    }
}

