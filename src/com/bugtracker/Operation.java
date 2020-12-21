package com.bugtracker;

import java.io.IOException;

public enum Operation {
    LOGIN, REGISTER, CREATE, EDIT, VIEW, EXIT;

    // get logging / register operation (LOGIN , REGISTER) or exit
    public static Operation getLoginOperationByOrdinal() throws IOException {
        while (true) {
            try {
                System.out.println("Enter:\n1 - to login\n2 - to register\n3 - to exit\n");
                int loginMenuVariant = ReadHelper.readNumber();
                switch (loginMenuVariant) {
                    case 1:
                        return LOGIN;
                    case 2:
                        return REGISTER;
                    case 3:
                        return EXIT;
                    default:
                        throw new IllegalArgumentException("Please, choose correct variant!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // get one of routine Operations (CREATE, EDIT, VIEW) or exit
    public static Operation getRoutineOperationByOrdinal() throws IOException {
        while (true) {
            try {
                System.out.println("Enter:\n1 - Create ticket\n2 - Edit ticket\n3 - View ticket\n4 - Exit");
                int mainMenuVariant = ReadHelper.readNumber();
                switch (mainMenuVariant) {
                    case 1:
                        return CREATE;
                    case 2:
                        return EDIT;
                    case 3:
                        return VIEW;
                    case 4:
                        return EXIT;
                    default:
                        throw new IllegalArgumentException("Please, choose correct variant!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

