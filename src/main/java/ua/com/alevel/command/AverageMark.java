package ua.com.alevel.command;

import ua.com.alevel.service.GroupService;

import java.util.Map;

public class AverageMark implements ICommand {
    private static final GroupService GROUP_SERVICE = GroupService.getInstance();

    @Override
    public void execute() {
        Map<String, Double> map = GROUP_SERVICE.getAverageMarkOfEveryGroup();
        if (map.isEmpty()) {
            System.out.println("\nInvalid query!");
            return;
        }
        map.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
