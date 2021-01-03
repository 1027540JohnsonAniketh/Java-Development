package edu.neu.csye6200.factory;

import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Teacher;

public class TeacherFactory extends PersonFactory {
	
	private static TeacherFactory instance;

	public static TeacherFactory getinstance() {
		if(instance == null) {
			instance = new TeacherFactory();
		}
		return instance;
	}

	@Override
	public Person getObject(String csvData) {
		return new Teacher(csvData);
	}

}
