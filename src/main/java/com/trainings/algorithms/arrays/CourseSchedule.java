package com.trainings.algorithms.arrays;

import java.util.*;

public class CourseSchedule {

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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Course> courses = new HashMap<>();
        int firstCourse = prerequisites[0][0];
        for (int[] prerequisite: prerequisites) {

            firstCourse = Math.min(firstCourse, prerequisite[0]);
            Course course = courses.get(prerequisite[0]);
            if(course == null) {
                course = new Course(prerequisite[0]);
                courses.put(prerequisite[0], course);
            }
            Course dependency = courses.get(prerequisite[1]);
            if(dependency == null) {
                dependency = new Course(prerequisite[1]);
                courses.put(prerequisite[1], dependency);
            }
            course.getDependencies().add(dependency);
        }

        System.out.println(courses);

        System.out.println(firstCourse);

        for (int i = firstCourse; i < numCourses; i++) {
            Course course = courses.get(i);
            if (!canFinish(course, "")) return false;
        }

        return true;
    }

    private static boolean canFinish(Course course, String parent) {
        if(course == null) {
            return true;
        }

        if(!parent.isEmpty()) {
            parent += ",";
        }
        parent += course.getValue();

        List<String> parentCourses = Arrays.stream(parent.split(",")).toList();
        for(Course dependency : course.getDependencies()) {
           if(parentCourses.contains(String.valueOf(dependency.getValue()))) {
               return false;
           }
        }

        for(Course dependency : course.getDependencies()) {
            if (!canFinish(dependency, parent)) return false;
        }

        return true;
    }

}
