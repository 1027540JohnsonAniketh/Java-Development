package edu.neu.csye6200.model;

import edu.neu.csye6200.utils.DateUtil;

import java.util.Date;

public class Student extends Person {

    private float gpa;
    private String entryDate;
    private final String lastRegistrationDate ="01-01-2018";
    //private final String lastRegistrationDate ="01-12-2021";
    private ImmunizationRecord immunizationRecord;
    private Parent parent;

    public Student(String csvData) {
        String[] data = csvData.split(",");
        this.setName(data[0]);
        this.setAge(Integer.parseInt(data[1]));
        this.setGpa(Float.parseFloat(data[2]));
        this.setEntryDate(DateUtil.parseDatetoString(new Date()));
        this.setParent(new edu.neu.csye6200.model.Parent(data[5],data[6],data[7]));
        this.setImmunizationRecord(new ImmunizationRecord(csvData));
    }

    public Student(String name, int age,float gpa,Parent p, ImmunizationRecord immunizationRecord) {
        this.setName(name);
        this.setAge(age);
        this.setGpa(gpa);
        this.setParent(p);
        this.setImmunizationRecord(immunizationRecord);
        this.setEntryDate((DateUtil.parseDatetoString(new Date())));
    }

    public String getEntryDate() {

        return entryDate;
    }

    public void setEntryDate(String entryDate) {

        this.entryDate = entryDate;
    }

    public String getLastRegistrationDate() {

        return lastRegistrationDate;
    }

    public ImmunizationRecord getImmunizationRecord() {

        return immunizationRecord;
    }

    public void setImmunizationRecord(ImmunizationRecord immunizationRecord) {
        this.immunizationRecord = immunizationRecord;
    }

    @Override
    public String toString() {
        return "\t Name: " + this.getName()+"\t Age: " +this.getAge()+"\t GPA: "+this.getGpa()+"\t Immunization Record: "
                + this.immunizationRecord +"\t Parent: " + this.parent;
    }


    public float getGpa() {

        return gpa;
    }

    public void setGpa(float gpa) {

        this.gpa = gpa;
    }

    public Parent getParent(){

        return parent;
    }

    public void setParent(Parent parent){

        this.parent = parent;
    }

}
