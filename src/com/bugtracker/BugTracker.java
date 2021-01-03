package com.bugtracker;

import com.bugtracker.view.View;
import java.io.IOException;

public class BugTracker {

    public static void main(String[] args) throws IOException {
        View view = new View();
        view.login();
        view.routine();
    }

}
