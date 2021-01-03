package com.bugtracker;

public enum Operation {
    LOGIN, REGISTER, CREATE, EDIT, VIEW, EXIT;

    // get logging / register operation (LOGIN , REGISTER) or exit
    public static Operation getLoginOperationByOrdinal() {
        while (true) {

            System.out.println("Enter:\n1 - to login\n2 - to register\n3 - to exit\n");
            int loginMenuVariant = ReadHelper.readNumber();
            try {
                return switch (loginMenuVariant) {
                    case 1 -> LOGIN;
                    case 2 -> REGISTER;
                    case 3 -> EXIT;
                    default -> throw new IllegalArgumentException("Please, choose correct variant!");
                };
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // get one of routine Operations (CREATE, EDIT, VIEW) or exit
    public static Operation getRoutineOperationByOrdinal() {
        while (true) {
            System.out.println("Enter:\n1 - Create ticket\n2 - Edit ticket\n3 - View ticket\n4 - Exit");
            int mainMenuVariant = ReadHelper.readNumber();
            try {
                return switch (mainMenuVariant) {
                    case 1 -> CREATE;
                    case 2 -> EDIT;
                    case 3 -> VIEW;
                    case 4 -> EXIT;
                    default -> throw new IllegalArgumentException("Please, choose correct variant!");
                };
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

