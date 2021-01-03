package edu.neu.csye6200.factory;

import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Student;

public class StudentFactory extends PersonFactory {

    private static StudentFactory instance;

    public static StudentFactory getinstance() {
        if(instance == null) {
            instance = new StudentFactory();
        }
        return instance;
    }

    @Override
    public Person getObject(String csvData) {
        return new Student(csvData);
    }

}
