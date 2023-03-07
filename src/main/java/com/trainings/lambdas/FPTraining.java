package com.trainings.lambdas;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FPTraining {

    public static List<Person> getPeople() {
        FPTraining training = new FPTraining();
        List<Person> people = List.of(
                training.new Person("Antonio Carlos", 34, Gender.MALE),
                training.new Person("Maria das Dores", 39, Gender.FEMALE),
                training.new Person("Jose De Las Flores", 23, Gender.MALE),
                training.new Person("Ramon Dos Anjos", 13, Gender.MALE),
                training.new Person("Tarciane da Silva", 24, Gender.FEMALE));

        return people;
    }

    public static Collection<Person> getMalePeople() {
        return getPeople().stream().filter(person -> person.getGender().equals(Gender.MALE)).collect(Collectors.toList());
    }

    public static Map<Gender, List<Person>> getGenderMap() {
        return getPeople().stream().collect(Collectors.groupingBy(Person::getGender));
    }

    public static Person getYoungestPerson() {
        return getPeople().stream().min(Comparator.comparing(Person::getAge)).get();
    }

    public static Person getOldestMalePerson() {
        return getPeople().stream().filter(person -> person.getGender().equals(Gender.MALE)).max(Comparator.comparing(Person::getAge)).get();
    }

    public static boolean isEverybodyEqualOrOver18() {
        return getPeople().stream().allMatch(person -> person.age >= 18);
    }

    public static List<Person> getPeopleUnder18() {
        return getPeople().stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
    }

    public static String getFinalPrice(ProductB product) {
        UnaryOperator<Double> discount = price -> price * (1 - product.getDiscount());
        UnaryOperator<Double> countyTax = price -> price >= 2500 ? price * 1.085 : price;
        UnaryOperator<Double> deliveryTax = price -> price >= 3000 ? price + 100 : price + 50;
        Function<Double, String> toStringWithTwoDecimalPlaces = price -> String.format("R$%.2f", price);
        return discount.andThen(countyTax).andThen(deliveryTax).andThen(toStringWithTwoDecimalPlaces).apply(product.getPrice());
    }

    enum Gender {
        MALE, FEMALE
    }

    public class Person {
        private String name;
        private Integer age;
        private Gender gender;

        public Person(String name, Integer age, Gender gender) {
            super();
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + Objects.hash(age, gender, name);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Person other = (Person) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            return Objects.equals(age, other.age) && gender == other.gender && Objects.equals(name, other.name);
        }

        private FPTraining getEnclosingInstance() {
            return FPTraining.this;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
        }
    }

}
