package edu.neu.csye6200.utils;


import edu.neu.csye6200.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SqlUtil {

    public static void insertStudentTable(List<Student> students){
        List<String> studentList=new LinkedList<>();

        students.forEach(s->{
            studentList.add(s.getName());
        });

        String url = "jdbc:mysql://localhost:3306/daycareDB";
        String user = "greta";
        String password = "greta";
        int idx=1;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO student(rollno,studentname)  values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            Iterator<String> iterator=studentList.iterator();
            while (iterator.hasNext()) {
                if(idx>studentList.size()-1)
                    break;
                statement.setString(1, String.valueOf(idx));
                statement.setString(2, studentList.get(idx));
                idx++;

                statement.executeUpdate();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Cannot add to database");
        }
    }
}
