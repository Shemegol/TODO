package com.shemegol;

import java.util.ArrayList;
import java.util.List;

class StorageOfTasks {
    private static List<Task> tasks = new ArrayList<>();

    void addTask(Task task) {
        tasks.add(task);
    }

    Task getTask(int taskNumber) {
        return tasks.get(taskNumber);
    }

    int getSize() {
        return tasks.size();
    }

    void removeTask(int taskNumber) {
        tasks.remove(taskNumber);
    }
}
