package ua.com.alevel.command;

import ua.com.alevel.model.Group;
import ua.com.alevel.service.GroupService;

import java.util.List;

public class AmountOfStudents implements ICommand {
    private static final GroupService GROUP_SERVICE = GroupService.getInstance();

    @Override
    public void execute() {
        List<Group> list = GROUP_SERVICE.returnAllGroups();
        if (list.isEmpty()) {
            System.out.println("\nNo students");
        } else {
            list.forEach(group -> {
                System.out.print("\n" + group.getName() + " : " + group.getStudents().size() + " students");
                System.out.println();
            });
        }
    }
}
