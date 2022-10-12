package ua.com.alevel.command;

public enum Commands {
    SEARCH_GROUPS_BY_NAMING("Search groups using naming", new SearchGroups()),
    GET_AMOUNT_OF_STUDENTS("Amount of students (in each group)", new AmountOfStudents()),
    AVERAGE_MARK_PER_GROUP("Average mark per group", new AverageMark()),
    SEARCH_TEACHER_BY_NAME("Get teacher by name", new SearchTeacher()),
    GET_BEST_AND_BED_SUBJECTS("Get subjects with performance", new SubjectPerformance()),
    STUDENTS_MARK_GREAT_THAN("Get students with avg mark great than", new StudentMark()),
    EXIT("Exit", null);

    private final String name;
    private final ICommand command;

    Commands(String name, ICommand command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public ICommand getCommand() {
        return command;
    }

    public boolean execute() {
        if (command == null) {
            return false;
        }
        command.execute();
        return true;
    }
}
