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
public class professor extends person {

    professor() throws IOException {

    }
    Scanner scan = new Scanner(System.in);

    public boolean login(String name, int password) throws SQLException {
        String dbCode = "";
        String dbCourseName = "";
        String dbProfName = "";
        int dbprofPassword = 0, dbLevel = 0;;
        ResultSet result = getProfData(name);
        while (result.next()) {
            dbProfName = result.getString("professor");
            dbprofPassword = result.getInt("password");
            dbCode = result.getString("code");
            dbCourseName = result.getString("name");
            dbLevel = result.getInt("level");
        }

        if (name.equals(dbProfName) && password == dbprofPassword) {
            System.out.println("Hello Professor " + dbProfName+",");
            System.out.println("your Course: " + dbCourseName + " " + dbCode
                    + " for level: " + dbLevel);

            return true;
        } else {

            //IMPORTANT: This flag is meant for the main as to provide a flag to be given and thus help you make the user
            return false;
        }
    }

    public void showStudents(String name) throws SQLException {
        int dbLevel = 0;
        String dbstudentName;
        ResultSet result1 = getProfData(name);
        while (result1.next()) {
            dbLevel = result1.getInt("level");
        }
        ResultSet result2 = getLevelsData(dbLevel);
        ResultSetMetaData rsmd = result2.getMetaData();

        int columnsNumber = rsmd.getColumnCount();
        System.out.println("Students Enrolled in Your Course: ");
        while (result2.next()) {

            for (int i = 1; i <= 1; i++) {

                dbstudentName = result2.getString(3);
                System.out.print(dbstudentName + " ");
            }
            System.out.println("");
        }
    }
}
