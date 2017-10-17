package com.company.university.entities;

import java.util.ArrayList;

public class Subject {
    private String subject_Name;
    private ArrayList<Integer> evaluations;

    public Subject() {
    }

    public String getSubject_Name() {
        return subject_Name;
    }

    public ArrayList<Integer> getEvaluations() {
        return evaluations;
    }

    public void setSubject_Name(String subject_Name) {
        this.subject_Name = subject_Name;
    }

    public void setEvaluations(ArrayList<Integer> evaluations) {
        this.evaluations = evaluations;
    }
}
