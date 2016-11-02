package com.shemegol;

import java.util.Date;

class Task {
    private String description;
    private Date dateToDo;

    Task(String description) {
        this.description = description;
    }

    Task(String description, Date dateToDo) {
        this.description = description;
        this.dateToDo = dateToDo;
    }

    public String toString() {
        if (dateToDo != null) {
            return description + "выполнить к " + dateToDo;
        } else return description;
    }
}
