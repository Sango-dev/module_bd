package ua.com.alevel.controller;

import ua.com.alevel.command.Commands;
import ua.com.alevel.util.UtilInputUser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Controller {
    private Controller() {}

    public static void run() {
        final Commands[] commands = Commands.values();
        boolean exit;

        do {
            exit = chooseAction(commands);
        } while (exit);
    }

    private static boolean chooseAction(Commands[] commands) {
        System.out.println("\nChoose action:");
        final List<String> names = Arrays.stream(commands)
                .map(command -> command.getName())
                .collect(Collectors.toList());

        final int userInput = UtilInputUser.getUserInput(names);
        return commands[userInput].execute();
    }
}
