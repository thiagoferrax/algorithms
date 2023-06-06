package com.trainings.algorithms.arrays;

import java.util.*;

public class CourseSchedule {

    private static boolean canFinish(Course course, String parent, Map<Integer, Boolean> memoization) {
        Boolean canFinish = memoization.get(course.getValue());
        if (canFinish != null) {
            return canFinish;
        }

        System.out.println(course);

        if (parent.length() > 1) {
            parent += "|";
        }
        parent += course.getValue();

        for (Course dependency : course.getDependencies()) {
            String value = "|" + String.valueOf(dependency.getValue()) + "|";
            if (parent.contains(value)) {
                return false;
            }
        }

        for (Course dependency : course.getDependencies()) {
            if (!canFinish(dependency, parent, memoization)) return false;
        }

        memoization.put(course.value, Boolean.TRUE);

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Course> courses = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            Course course = courses.get(prerequisite[0]);
            if (course == null) {
                course = new Course(prerequisite[0]);
                courses.put(prerequisite[0], course);
            }
            Course dependency = courses.get(prerequisite[1]);
            if (dependency == null) {
                dependency = new Course(prerequisite[1]);
                courses.put(prerequisite[1], dependency);
            }
            course.getDependencies().add(dependency);
        }

        System.out.println(courses);

        List<Integer> sorted = courses.keySet().stream().sorted().toList();
        Map<Integer, Boolean> memoization = new HashMap<>();
        for (Integer courseId : sorted) {
            Course course = courses.get(courseId);
            if (!canFinish(course, "|", memoization)) return false;
        }

        return true;
    }

    public class Course {
        int value;
        Set<Course> dependencies;

        public Course(int value) {
            this.value = value;
            this.dependencies = new HashSet<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Course course = (Course) o;
            return value == course.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Course{" +
                    "value=" + value +
                    '}';
        }

        public int getValue() {
            return value;
        }

        public Set<Course> getDependencies() {
            return dependencies;
        }
    }

}
