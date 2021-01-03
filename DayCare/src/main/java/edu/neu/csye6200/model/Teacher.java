package edu.neu.csye6200.model;

public class Teacher extends Person {
	private int credits;

	public Teacher(String csvData) {
		String[] data = csvData.split(",");
		this.setName(data[0]);
		this.setAge(Integer.parseInt(data[1]));
		this.setCredits(Integer.parseInt(data[2]));
	}
	
	public Teacher(String name, int age, int credits) {
		this.setName(name);
		this.setAge(age);
		this.setCredits(credits);
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\t Age: " + this.getAge() + "\t Credits: " + this.credits;
	}
}
