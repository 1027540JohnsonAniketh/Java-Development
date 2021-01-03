package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private Regulations regulations;
	private List<Teacher> teachers;
	private List<Student> students;
	private int capacity;


	public Classroom(Regulations regulations) {
		this.setRegulation(regulations);
		this.setTeachers(new ArrayList<>());
		this.setStudents(new ArrayList<>());
	}
        
	public void addStudent(Student s){

		this.students.add(s);
	}

	public void addTeacher(Teacher t){

		this.teachers.add(t);
	}

	public Regulations getRegulations() {

		return regulations;
	}

	public void setRegulation(Regulations regulations) {

		this.regulations = regulations;
	}

	public List<Teacher> getTeachers() {

		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {

		this.teachers = teachers;
	}

	public List<Student> getStudents() {

		return students;
	}

	public void setStudents(List<Student> students) {

		this.students = students;
	}

	public void setRegulations(Regulations regulations) {
		this.regulations = regulations;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(regulations.toString());
		sb.append("\n Teachers: ");
		teachers.forEach(t -> {
			sb.append(t.getName() + "  ");
		});
		sb.append("\n Student: ");
		students.forEach(s -> {
			sb.append(s.getName() + ",");
		});
		return sb.toString();
	}
}
