/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

/**
 *
 * @author Erini
 */
import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.Random;

public class administrator extends person {

    administrator() throws IOException {

    }
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    //method for adding new students to the database
    public void addStudent() throws SQLException, ClassNotFoundException {
        int studentPassword = 0;
        studentPassword = rand.nextInt(999); //random password generator        
        String studentName;
        System.out.println("Enter student's full name: ");
        studentName = scan.next();
        double studentGPA = 0;
        int studentLevel;
        System.out.println("Enter student's level");
        studentLevel = scan.nextInt();

        Class.forName(DRIVER);
        Cursor = DriverManager.getConnection(URL, USER, PASSWORD);

        //This Alert To Verify If The conection has succeed or Not
        State = Cursor.createStatement();
        String query = "INSERT INTO `student` (password,name,GPA,level) VALUES ('" + studentPassword + "','" + studentName + "','" + studentGPA + "','" + studentLevel + "') ";
        State.executeUpdate(query); //adding new student info into the database
        System.out.println("Student added successfully!");
    }

    //method for removing students from database

    public void removeStudent() throws SQLException {
        String givenID;
        System.out.println("Please enter the ID for deactivation");
        givenID = scan.next();
        boolean CheckerForCorrectInfo; //flag checking if the id exists in the database
        if (IDExist(Integer.valueOf(givenID)).equals("Not Found")) {
            CheckerForCorrectInfo = false;
        } else {
            CheckerForCorrectInfo = true;
        }
        while (!CheckerForCorrectInfo) {
            System.out.println("Please make sure that you re-enter the info correctly");
            givenID = scan.next();
            if (IDExist(Integer.valueOf(givenID)).equals("Not Found")) {
                CheckerForCorrectInfo = false;
            } else {
                CheckerForCorrectInfo = true;

            }
        }

        Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
        State = Cursor.createStatement();
        String query = "DELETE FROM student WHERE id='" + givenID + "'"; //removing the whole row from the database
        State.executeUpdate(query);
        System.out.println("Student removed successsfully!");

    }
    /*new students GPA is set to zero this method is for updating the GPA*/

    public void UpdateGPA() throws ClassNotFoundException, SQLException {
        int ID;
        double NewGPA;
        System.out.println("Enter Student ID: ");
        ID = scan.nextInt();
        System.out.println("Enter New GPA: ");
        NewGPA = scan.nextDouble();
        if (NewGPA > 4) {
            System.out.println("GPA can't be more than 4.0 \nplease enter the correct GPA: ");
            NewGPA = scan.nextDouble();
        } else {
            Class.forName(DRIVER);
        }
        Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
        State = Cursor.createStatement();
        String query = "UPDATE student SET GPA = '" + NewGPA + "' WHERE id = '" + ID + "'";
        State.executeUpdate(query);//adding the new GPA to the row where the entered ID belong
        System.out.println("GPA updated successfully!");
    }

    public void addCourse() throws SQLException, ClassNotFoundException {
        String courseCode;
        System.out.println("Enter Course Code: ");
        courseCode = scan.next();
        String courseName;
        System.out.println("Enter Course name: ");
        courseName = scan.next();
        String professorName;
        System.out.println("Enter Professor's name: ");
        professorName = scan.next();
        int profpassword = rand.nextInt(999);
        int courseLevel;
        System.out.println("Enter course level");
        courseLevel = scan.nextInt();

        Class.forName(DRIVER);
        Cursor = DriverManager.getConnection(URL, USER, PASSWORD);

        //This Alert To Verified If The conection Is succeed or Not
        State = Cursor.createStatement();
        String query = "INSERT INTO `course` (code,name,professor,password,level) VALUES ('" + courseCode + "','" + courseName + "','" + professorName + "','" + profpassword + "','" + courseLevel + "') ";
        State.executeUpdate(query); //adding a new row to table course in the database with all the entered info
        System.out.println("Course added successfully!");
    }

    public void removeCourse() throws SQLException {
        String givenCode;
        System.out.println("Please enter the course code for deleting: ");
        givenCode = input.next();
        boolean CheckerForCorrectInfo;
        if (codeExist(givenCode).equals("Not Found")) {
            CheckerForCorrectInfo = false;
        } else {
            CheckerForCorrectInfo = true;
        }
        while (!CheckerForCorrectInfo) {
            System.out.println("Please make sure that you re-enter the info correctly: ");
            givenCode = input.next();
            if (codeExist(givenCode).equals("Not Found")) {
                CheckerForCorrectInfo = false;
            } else {
                CheckerForCorrectInfo = true;

            }
        }

        Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
        State = Cursor.createStatement();
        String query = "DELETE FROM course WHERE code='" + givenCode + "'"; //deleting the whole row with th entered code
        State.executeUpdate(query);
        System.out.println("Course removed successfully!");

    }
}
