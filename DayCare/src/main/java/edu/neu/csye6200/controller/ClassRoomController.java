package edu.neu.csye6200.controller;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Regulations;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassRoomController {
    public static List<Classroom> classroomList = new ArrayList<>();
    private static int teacherCounter = 0;
    
    public static void createClassroom(Student student, Teacher teacher){
        int sAge = student.getAge();
        Regulations regulations = RegulationsController.rules.stream().filter((rule) -> rule.getMinAge() <= sAge && rule.getMaxAge() >= sAge).findFirst().get();
        Classroom classroom = new Classroom(regulations);
        classroom.addStudent(student);
        classroom.addTeacher(teacher);
        ClassRoomController.classroomList.add(classroom);
    }
    
    public static boolean isFull(Classroom c){
        return c.getStudents().size() >= c.getRegulations().getGroupSize() * c.getRegulations().getMaxGroupPerRoom();
    }
    
    public static boolean isTeacherExistForClassroom(Classroom c){
        return c.getStudents().size() == c.getTeachers().size() * c.getRegulations().getGroupSize();
    }
    
    public static void addStudentToClassroom(Student student){
        int mAge = student.getAge();
        RegulationsController.createRules();
        //Get the Group based on the age from rules in
        Regulations regulations = RegulationsController.rules.stream().filter((rule) -> rule.getMinAge() <= mAge && rule.getMaxAge() >= mAge).findFirst().get();
        //Get the classroom group
        List<Classroom> classroomList = ClassRoomController.classroomList.stream().filter(c -> c.getRegulations().getMinAge() == regulations.getMinAge()).collect(Collectors.toList());
        //Check if the classroom is empty otherwise enter the block
        if(!classroomList.isEmpty()){
            Iterator<Classroom> it = classroomList.listIterator();
            while(it.hasNext()){
                Classroom classroom = it.next();
                //If the classroom is full create a new one
                if(isFull(classroom) && !it.hasNext()){
                    ClassRoomController.createClassroom(student, TeacherController.teachers.get(teacherCounter++));
                }else if(isTeacherExistForClassroom(classroom)){
                    //If the teacher does'nt exist add the teacher and student to classroom
                    classroom.addTeacher(TeacherController.teachers.get(teacherCounter++));
                    classroom.addStudent(student);
                } else {
                    classroom.addStudent(student);
                }
            }
        } else {
            try {
                ClassRoomController.createClassroom(student, TeacherController.teachers.get(teacherCounter++));
            }catch (IndexOutOfBoundsException e){
            }
        }
    }
    public static List<Classroom> getClassroomList(){
        return classroomList;
    }
    public static void classroomAllocation(){
        classroomList.clear();
        teacherCounter = 0;
        //Iterate through each student object and call addStudentToClassroomMethod
       StudentController.studentList.stream().forEach(s -> addStudentToClassroom(s));
    }
}
