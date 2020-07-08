/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Erini
 */
public class student extends person {

    Scanner scan = new Scanner(System.in);

    student() throws IOException {

    }

    public boolean login() throws SQLException {
        int id, password;
        System.out.println("Enter your ID: ");
        id = scan.nextInt();
        System.out.println("Enter your password: ");
        password = scan.nextInt();
        int dbID = 0, dbLevel=0;
        int dbPassword = 0;
        String dbStudentName = "";
        double dbGPA=0;
        ResultSet result1 = getStudentData(id);
        while (result1.next()) {
            dbID = result1.getInt("id");
            dbPassword = result1.getInt("password");
            dbStudentName = result1.getString("name");
            dbGPA=result1.getDouble("GPA");
            dbLevel=result1.getInt("level");
        }
        String dbCode = null;
        String dbCourseName = null;
        String dbProfName = null;
        ResultSet result2=getCourseData(dbLevel);
        while(result2.next()){
            dbCode=result2.getString("code");
            dbCourseName=result2.getString("name");
            dbProfName=result2.getString("professor");
        }
        if (id == dbID && password == dbPassword) {
            System.out.println("Hello " + dbStudentName+",");
            System.out.println("your GPA: "+dbGPA+"\nyour level: "+dbLevel+"\nyour are enrolled in: "+dbCourseName +" "+dbCode
                    +" with professor: "+dbProfName);
            return true;
        } else {
            System.out.println("Incorrect id or Password");
            //IMPORTANT: This flag is meant for the main as to provide a flag to be given and thus help you make the user
            return false;                                                                          
        }
    }

    }

