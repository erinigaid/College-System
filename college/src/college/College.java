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
public class College {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void admin() throws IOException, SQLException, ClassNotFoundException {
        String email, password;
        final String adminEmail = "admin@admin.com";
        final String adminPassword = "admin";
        System.out.println("Enter the Email");
        email = scan.next();
        System.out.println("Enter the Password");
        password = scan.next();
        while (true) {
            if (email.equals(adminEmail) && password.equals(adminPassword)) {
                inadmin();
                break;
            } else {
                System.out.println("invalid email or password\n1 = Try again!\n2 = Home\n3 = Exit\nEnter Your Choice : ");
                while (true) {
                    int Flag = scan.nextInt();
                    switch (Flag) {
                        case 1:
                            admin();
                            break;
                        case 2:
                            mainMenu();
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.out.println("Invalid Choice ");
                            break;
                    }

                }
            }
        }
    }

    public static void inadmin() throws IOException, SQLException, ClassNotFoundException {
        administrator admin = new administrator();
        while (true) {
            System.out.println("1 = Add New Student \n2 = Remove Student\n3 = Update Student GPA\n"
                    + "4 = Add New Course\n5 = Remove Course \n6 = Logout \n7 = Exit\n"
                    + "Enter Your Choice : ");

            int adminChoice = scan.nextInt();
            switch (adminChoice) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.removeStudent();
                    break;
                case 3:
                    admin.UpdateGPA();
                    break;
                case 4:
                    admin.addCourse();
                    break;
                case 5:
                    admin.removeCourse();
                    break;
                case 6:
                    mainMenu();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice ");
                    inadmin();
                    break;
            }
        }
    }

    public static void professor() throws IOException, SQLException, ClassNotFoundException {

        System.out.println("Enter your name: ");
        String pName = scan.next();
        System.out.println("Enter your password: ");
        int pPassword = scan.nextInt();
        professor prof = new professor();
        while (true) {
            if (prof.login(pName, pPassword)) {
                prof.showStudents(pName);
                mainMenu();
                break;
            } else {
                System.out.println("invalid id or password\n1 = Try again!\n2 = Home\n3 = Exit\nEnter Your Choice : ");
                int Flag = scan.nextInt();
                switch (Flag) {
                    case 1:
                        professor();
                        break;
                    case 2:
                        mainMenu();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice ");
                        break;
                }
            }
        }
    }

    public static void student() throws IOException, SQLException, ClassNotFoundException {
        student stu = new student();
        while (true) {
            if (stu.login()) {
                mainMenu();
                break;
            } else {
                System.out.println("invalid id or password\n1 = Try again!\n2 = Home\n3 = Exit\nEnter Your Choice : ");
                int Flag = scan.nextInt();
                switch (Flag) {
                    case 1:
                        student();
                        break;
                    case 2:
                        mainMenu();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice ");
                        break;
                }
            }
        }
    }

    public static void mainMenu() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Welcome to our University");
        System.out.println("1 = Administrator\n" + "2 = Professor\n" + "3 = Student\n" + "4 = Exit \n" + "Enter your choice:");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                admin();
                break;
            case 2:
                professor();
                break;
            case 3:
                student();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                mainMenu();
                break;
        }

    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        {
            // TODO code application logic here 
            while (true) {
                mainMenu();

            }

        }
    }
}
