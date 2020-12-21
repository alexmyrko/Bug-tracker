package com.bugtracker;

import java.io.IOException;

public enum Operation {
    LOGIN, REGISTER, CREATE, EDIT, VIEW, EXIT;

    // get logging / register operation (LOGIN , REGISTER) or exit
    public static Operation getLoginOperationByOrdinal() throws IOException {
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
    }
}