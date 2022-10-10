package ua.com.alevel.command;

import ua.com.alevel.model.Student;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.model.Group;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class SearchGroups implements ICommand {
    private static final GroupService SERVICE = GroupService.getInstance();
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute() {
        try {
            System.out.print("\ngroup's name -> ");
            String name = READER.readLine();
            List<Group> list = SERVICE.searchGroupsUsingName(name);

            if (list.isEmpty()) {
                System.out.println("Groups are not existing with this name : " + name);
                return;
            }

            list.forEach(group -> {
                System.out.println("\n" + group.getName() + " : ");
                int i = 0;
                for (Student student : group.getStudents()) {
                    i++;
                    System.out.println(i + ") " + student);
                }
                System.out.println();
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
