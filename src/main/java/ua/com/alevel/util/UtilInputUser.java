package ua.com.alevel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public final class UtilInputUser {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    private UtilInputUser() {
    }

    public static int getUserInput(List<String> names) {
        int userType = -1;
        do {
            userType = getUserInputPrivate(names);
        } while (userType == -1);
        return userType;
    }

    private static int getUserInputPrivate(List<String> names) {
        try {
            System.out.println();
            for (int i = 0; i < names.size(); i++) {
                System.out.printf("%d) %s%n", i, names.get(i));
            }

            System.out.print("\nPlease enter number between 0 and " + names.size() + "  -> ");
            int input = Integer.parseInt(READER.readLine());
            if (input >= 0 && input < names.size()) {
                return input;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input is not valid");
        }
        return -1;
    }
}
