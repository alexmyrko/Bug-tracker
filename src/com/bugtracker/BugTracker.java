package com.bugtracker;

import com.bugtracker.dao.*;
import com.bugtracker.view.View;

public class BugTracker {
    private static MemoryModel memoryModel;
    public static void main(String[] args) {
        View view = new View();
        while (memoryModel == null)
            memoryModel = view.memoryModel();
        while(true){
            view.login();
            view.routine();
        }
    }

    public static MemoryModel getMemoryModel(){
        return memoryModel;
    }

}
