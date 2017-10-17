package com.company.university.entities;

import java.util.ArrayList;

public class Group {
    private int groupNumber;
    private ArrayList<Student> students;

    public Group() {
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
