package com.company.university.functions;

import com.company.university.entities.*;

public interface IAvgEvaluation {
    double avg_for_subject(Subject subject);
    double avg_for_student(Student student);
    double avg_for_group(Group group);
    double avg_for_faculty(Faculty faculty);
    double avg_for_university(University university);
    void printResult(String sparam, double iparam);
}
