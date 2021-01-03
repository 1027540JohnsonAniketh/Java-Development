package edu.neu.csye6200.controller;
import edu.neu.csye6200.factory.TeacherFactory;
import java.util.ArrayList;
import java.util.List;
import edu.neu.csye6200.model.Teacher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TeacherController {
	public static List<Teacher> teachers = new ArrayList<>();
	private static final File TEACHER_CSV = new File("Teachers.csv");
	
	public static void writeTeachersToCsv() {
		try{
			try (BufferedWriter writeText = new BufferedWriter(new FileWriter(TEACHER_CSV))) {
				for(Teacher t:TeacherController.teachers) {
					writeText.write(t.getName()+","+t.getAge()+","+t.getCredits());
					writeText.newLine();
				}
				writeText.flush();
			}
		}catch (IOException e){
			e.getStackTrace();
		}
	}
	public static void readTeachersFromCsv() {
		teachers.clear();
		try {
			try (BufferedReader readText = new BufferedReader(new FileReader(TEACHER_CSV))) {
				String lineText = "";
				while((lineText = readText.readLine() )!= null) {
					teachers.add((Teacher) TeacherFactory.getinstance().getObject(lineText));
				}
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	public static void addTeacher(String csvData) {
		teachers.add((Teacher) TeacherFactory.getinstance().getObject(csvData));
	}
	public static boolean verifyTeacherCsvData(String csvData) {
		String [] csvTextArray=csvData.split(",");
		if((Integer.parseInt(csvTextArray[2])<=2))
			return false;
		return true;
	}
}
