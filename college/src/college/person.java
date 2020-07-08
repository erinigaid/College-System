package college;

import java.util.Scanner;
import java.io.*;
import java.sql.*;

/**
 *
 * @author Erini
 */
public class person {

    Scanner input = new Scanner(System.in);

    person() throws IOException {

    }

    //DB Configuration
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/college";
    String USER = "root";
    String PASSWORD = "";
    Connection Cursor = null;
    Statement State = null;


    //method for checking if the entered course code exists in the datacode
      public String codeExist(String courseCode) throws SQLException {
        ResultSet result = getCourseData(courseCode);
        String code = "Not Found";
        while (result.next()) {
           code = result.getString("code");
        }
        return code;
    }
      //method for retrieving course info from the database
 public ResultSet getCourseData(String code) {
        ResultSet result = null;
        try {
            Class.forName(DRIVER);
            Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
            if (Cursor != null) {
            }
            State = Cursor.createStatement();
            String query = "SELECT * FROM course WHERE code= '" + code + "'";
            result = State.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            return result;
        } else {
            return null;
        }

    }
  public ResultSet getProfData(String Profname) {
        ResultSet result = null;
        try {
            Class.forName(DRIVER);
            Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
            if (Cursor != null) {
            }
            State = Cursor.createStatement();
            String query = "SELECT * FROM course WHERE professor= '" + Profname + "'";
            result = State.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            return result;
        } else {
            return null;
        }

    }
  public ResultSet getCourseData(int level) {
        ResultSet result = null;
        try {
            Class.forName(DRIVER);
            Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
            if (Cursor != null) {
            }
            State = Cursor.createStatement();
            String query = "SELECT * FROM course WHERE level= '" + level + "'";
            result = State.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            return result;
        } else {
            return null;
        }

    }
    public ResultSet getStudentData(int IDNum) {
        ResultSet result = null;
        try {
            Class.forName(DRIVER);
            Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
            if (Cursor != null) {
            }
            State = Cursor.createStatement();
            String query = "SELECT * FROM student WHERE id= '" + IDNum + "'";
            result = State.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            return result;
        } else {
            return null;

        }

    }
        //method checking if the entered id exists in the database
    public String IDExist(int IdNum) throws SQLException {
        ResultSet result = getStudentData(IdNum);
        String id = "Not Found";
        while (result.next()) {
            id = result.getString("id");
        }
        return id;
    }
    
    public ResultSet getLevelsData(int level) {
        ResultSet result = null;
        try {
            Class.forName(DRIVER);
            Cursor = DriverManager.getConnection(URL, USER, PASSWORD);
            if (Cursor != null) {
            }
            State = Cursor.createStatement();
            String query = "SELECT * FROM student WHERE level= '" + level + "'";
            result = State.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            return result;
        } else {
            return null;

        }

    }

}
