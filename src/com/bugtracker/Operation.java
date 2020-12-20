package com.bugtracker;

public enum Operation {
    LOGIN, REGISTER, CREATE, EDIT, VIEW, EXIT;

    // get logging / register operation (LOGIN , REGISTER) or exit
    public static Operation getLoginOperationByOrdinal(int loginMenuVariant) {
        System.out.println("Enter:\n1 - to login\n2 - to register\n3 - to exit\n");
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
    }
    // get one of routine Operations (CREATE, EDIT, VIEW) or exit
    public static Operation getRoutineOperationByOrdinal(int mainMenuVariant) {
        System.out.println("Enter:\n1 - to create a new ticket\n2 - to edit ticket\n3 - to view ticket\n4 - to exit\n");
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
    }
}

