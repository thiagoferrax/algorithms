package com.trainings.algorithms.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * The new Secretary of Education mandated that a Computerized Enrollment System
 * be created to prevent children and workers from reading information and
 * information on Public Health.
 * https://ucoder.com.br/problems/1005/
 */
public class RegistrationSystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Student> students = new ArrayList<Student>();

        while (scan.hasNext()) {
            String studentData = scan.next();
            while (scan.hasNext() && !studentData.contains(";")) {
                studentData += " " + scan.next();
            }
            students.add(new RegistrationSystem().new Student(studentData));
        }

        students.sort(new RegistrationSystem().new StudentComparator());

        int count = 1;
        for (Student student : students) {
            System.out.println(count + " " + student.name);
            count++;
        }

        scan.close();
    }

    private class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int comparison = 0;

            if (s1.liveNearSchool && !s2.liveNearSchool) {
                comparison = -1;
            } else if (!s1.liveNearSchool && s2.liveNearSchool) {
                comparison = 1;
            } else if (s1.familyIncome < s2.familyIncome) {
                comparison = -1;
            } else if (s2.familyIncome < s1.familyIncome) {
                comparison = 1;
            } else if (s1.familyBag && !s2.familyBag) {
                comparison = -1;
            } else if (!s1.familyBag && s2.familyBag) {
                comparison = 1;
            } else if (s1.brotherEnrolled && !s2.brotherEnrolled) {
                comparison = -1;
            } else if (!s1.brotherEnrolled && s2.brotherEnrolled) {
                comparison = 1;
            } else if (s1.motherWorkingOutside && !s2.motherWorkingOutside) {
                comparison = -1;
            } else if (!s1.motherWorkingOutside && s2.motherWorkingOutside) {
                comparison = 1;
            } else {
                comparison = s1.name.compareToIgnoreCase(s2.name);
            }

            return comparison;
        }

    }

    private class Student {

        private final String name;
        private final boolean liveNearSchool;
        private final double familyIncome;
        private final boolean familyBag;
        private final boolean brotherEnrolled;
        private final boolean motherWorkingOutside;
        public Student(String information) {
            String[] studentData = information.split(";");

            this.name = studentData[0];
            this.liveNearSchool = studentData[1].equals("S");
            this.familyIncome = Double.parseDouble(studentData[2]);
            this.familyBag = studentData[3].equals("S");
            this.brotherEnrolled = studentData[4].equals("S");
            this.motherWorkingOutside = studentData[5].equals("S");
        }
    }
}
