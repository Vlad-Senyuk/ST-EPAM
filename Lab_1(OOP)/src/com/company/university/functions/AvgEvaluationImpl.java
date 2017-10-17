package com.company.university.functions;

import com.company.university.entities.*;

import java.util.ArrayList;

public class AvgEvaluationImpl implements IAvgEvaluation {
    @Override
    public double avg_for_subject(Subject subject) {
        return getAvg(subject.getEvaluations());
    }

    @Override
    public double avg_for_student(Student student) {
        double sum = 0;

        for (int i = 0; i < student.getSubjects().size(); i++) {
            sum += avg_for_subject(student.getSubjects().get(i));
        }

        return sum/student.getSubjects().size();
    }

    @Override
    public double avg_for_group(Group group) {
        double sum = 0;

        for (int i = 0; i < group.getStudents().size(); i++) {
            sum += avg_for_student(group.getStudents().get(i));
        }
        return sum/group.getStudents().size();
    }

    @Override
    public double avg_for_faculty(Faculty faculty)
    {
        double sum = 0;

        for (int i = 0; i < faculty.getGroups().size(); i++) {
            sum += avg_for_group(faculty.getGroups().get(i));
        }

        return sum/faculty.getGroups().size();
    }

    @Override
    public double avg_for_university(University university) {
        double sum = 0;

        for (int i = 0; i < university.getFaculties().size(); i++) {
            sum += avg_for_faculty(university.getFaculties().get(i));
        }

        return sum/university.getFaculties().size();
    }

    @Override
    public void printResult(String sparam, double iparam) {
        System.out.println("AVG for " + sparam + "=" + String.valueOf(iparam));
    }

    private double getAvg(ArrayList<Integer> list){
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum/list.size();
    }
}
