package edu.neu.csye6200.controller;
import edu.neu.csye6200.factory.StudentFactory;
import edu.neu.csye6200.model.ImmunizationRecord;
import edu.neu.csye6200.model.ImmunizationRule;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.DateUtil;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentController {
    public static List<Student> studentList = new ArrayList<>();
    private static final File STUDENT_CSV = new File("Students.csv");

    public static void addStudent(String csvData) {
        studentList.add((Student) StudentFactory.getinstance().getObject(csvData));
    }

    public static Student findStudent(String name) {
        try {
            return StudentController.studentList.stream().filter(s -> s.getName().equals(name)).findFirst().get();
        }catch (Exception e){
            return null;
        }
    }


    public static boolean verifyStudentCsvData(String csvData){
        String[] csvArray=csvData.split(",");
        if(Integer.parseInt(csvArray[1])>120)
            return false;
        return true;
    }

    public static void writeStudentsToCsv() {
        try{
            try (BufferedWriter writeText = new BufferedWriter(new FileWriter(STUDENT_CSV))) {
                for(Student s:StudentController.studentList) {
                    writeText.write(s.getName()+","+s.getAge()+","+s.getGpa()+","+s.getImmunizationRecord()+","+s.getParent());
                    writeText.newLine();
                }
                writeText.flush();
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void readStudentsFromCsv() {
        studentList.clear();
        try {
            try (BufferedReader readText = new BufferedReader(new FileReader(STUDENT_CSV))) {
                String lineText;
                while((lineText = readText.readLine() )!= null) {
                    studentList.add((Student) StudentFactory.getinstance().getObject(lineText));
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static String takeHepatits(Student s){
        if(s.getImmunizationRecord().getHepatitisCount() < ImmunizationRule.HEPATITIS){
            s.getImmunizationRecord().setHepatitisCount(s.getImmunizationRecord().getHepatitisCount()+1);
            return s.getName() + " takes 1 dose of Hepatitis";
        }
        return s.getName() + " doesn't need to take Hepatitis vaccine";
    }

    public static String takePolio(Student s){
        if(s.getImmunizationRecord().getPolioCount() < ImmunizationRule.POLIO){
            s.getImmunizationRecord().setPolioCount(s.getImmunizationRecord().getPolioCount()+1);
            return s.getName() + " takes 1 dose of Polio";
        }
        return s.getName() + " doesn't need to take Polio vaccine";
    }
    public static List<Student> trackUpcomingRegistration(){
        return StudentController.studentList
                .stream()
                .filter( s -> (DateUtil.calculateMonthsBetweenTwoDates(s)<0))
                .collect(Collectors.toList());
    }
    public static String trackImmunization(Student s) {
        StringBuilder result=new StringBuilder();
        try {
            if (findStudent(s.getName()) == null) {
                System.out.println("Error");
            }
        }catch (Exception e){
            return "Student does'nt exist";
        }
        ImmunizationRecord immunizationRecord = s.getImmunizationRecord();

        if((immunizationRecord.getHepatitisCount() < ImmunizationRule.HEPATITIS)||(immunizationRecord.getPolioCount()<ImmunizationRule.POLIO)) {
            if(immunizationRecord.getPolioCount() < ImmunizationRule.POLIO) {
                result.append("Need " + (ImmunizationRule.POLIO - immunizationRecord.getPolioCount()) + " doses of Polio. \n");
            }
            result.append("Need " + (ImmunizationRule.HEPATITIS - immunizationRecord.getHepatitisCount()) + " doses of Hepatits.");
            System.out.println(result);
        }

        else{
             result.append("Meets all Immunization Rules");
        }
        return result.toString();
    }
}
