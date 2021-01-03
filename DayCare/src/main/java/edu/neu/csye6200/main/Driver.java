package edu.neu.csye6200.main;

import edu.neu.csye6200.controller.StudentController;
import edu.neu.csye6200.controller.TeacherController;
import edu.neu.csye6200.view.MainView;

public class Driver {

    public static void main(String[] args) {
        StudentController.readStudentsFromCsv();
        TeacherController.readTeachersFromCsv();
        new MainView().setVisible(true);

    }

}
