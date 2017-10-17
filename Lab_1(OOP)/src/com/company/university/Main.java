package com.company.university;

import com.company.university.entities.*;
import com.company.university.functions.AvgEvaluationImpl;
import com.company.university.functions.IAvgEvaluation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Subject subject1 = new Subject();
        subject1.setSubject_Name("OOP");
        subject1.setEvaluations(new ArrayList<Integer>(){{add(7); add(9); add(9);}});

        Subject subject2 = new Subject();
        subject2.setSubject_Name("OS");
        subject2.setEvaluations(new ArrayList<Integer>(){{add(6); add(8); add(4); add(10);}});

        Subject subject3 = new Subject();
        subject3.setSubject_Name("IS");
        subject3.setEvaluations(new ArrayList<Integer>(){{add(4); add(4); add(8);}});

        Student student1 = new Student();
        student1.setStudentName("Student-1");
        student1.setSubjects(new ArrayList<Subject>(){{add(subject1); add(subject2);}});

        Student student2 = new Student();
        student2.setStudentName("Student-2");
        student2.setSubjects(new ArrayList<Subject>(){{add(subject3);}});

        Group group1 = new Group();
        group1.setGroupNumber(1);
        group1.setStudents(new ArrayList<Student>(){{add(student1); add(student2);}});

        Group group2 = new Group();
        group2.setGroupNumber(2);
        group2.setStudents(new ArrayList<Student>(){{add(student1);}});

        Faculty faculty1 = new Faculty();
        faculty1.setFacultyName("FIT");
        faculty1.setGroups(new ArrayList<Group>(){{add(group1); add(group2);}});

        University university = new University();
        university.setUniversityName("BSTU");
        university.setFaculties(new ArrayList<Faculty>(){{add(faculty1);}});

        IAvgEvaluation avgEvaluation = new AvgEvaluationImpl();

        avgEvaluation.printResult(subject1.getSubject_Name(), avgEvaluation.avg_for_subject(subject1));
        avgEvaluation.printResult(subject2.getSubject_Name(), avgEvaluation.avg_for_subject(subject2));
        avgEvaluation.printResult(subject3.getSubject_Name(), avgEvaluation.avg_for_subject(subject3));

        avgEvaluation.printResult(student1.getStudentName(), avgEvaluation.avg_for_student(student1));
        avgEvaluation.printResult(student2.getStudentName(), avgEvaluation.avg_for_student(student2));

        avgEvaluation.printResult(String.valueOf(group1.getGroupNumber()), avgEvaluation.avg_for_group(group1));
        avgEvaluation.printResult(String.valueOf(group2.getGroupNumber()), avgEvaluation.avg_for_group(group2));

        avgEvaluation.printResult(faculty1.getFacultyName(), avgEvaluation.avg_for_faculty(faculty1));

        avgEvaluation.printResult(university.getUniversityName(), avgEvaluation.avg_for_university(university));
    }
}
