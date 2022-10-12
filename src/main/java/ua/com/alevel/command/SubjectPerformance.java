package ua.com.alevel.command;

import ua.com.alevel.service.SubjectService;

public class SubjectPerformance implements ICommand {
    private static final SubjectService SERVICE = SubjectService.getInstance();

    @Override
    public void execute() {
        SERVICE.getSubjectsPerformance();
    }
}
