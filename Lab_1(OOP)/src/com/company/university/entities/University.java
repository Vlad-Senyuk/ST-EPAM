package com.company.university.entities;

import java.util.ArrayList;

public class University {
    private String universityName;
    private ArrayList<Faculty> faculties;

    public University(){}

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }
}
