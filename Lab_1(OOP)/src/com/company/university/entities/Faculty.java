package com.company.university.entities;

import java.util.ArrayList;

public class Faculty {
    private String facultyName;
    private ArrayList<Group> groups;

    public Faculty() {
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}
