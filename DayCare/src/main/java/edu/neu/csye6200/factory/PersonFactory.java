package edu.neu.csye6200.factory;

import edu.neu.csye6200.model.Person;

public abstract class PersonFactory {
    public abstract Person getObject(String csvData);
}
