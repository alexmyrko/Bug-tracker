package com.bugtracker;

import java.io.IOException;

public enum Operation {
    LOGIN, REGISTER, CREATE, EDIT, VIEW, EXIT;

    // get logging / register operation (LOGIN , REGISTER) or exit
    public static Operation getLoginOperationByOrdinal() throws IOException {
        return LOGIN;
    }

    // get one of routine Operations (CREATE, EDIT, VIEW) or exit
    public static Operation getRoutineOperationByOrdinal(int n){
        // TODO
        return EXIT;
    }
}
