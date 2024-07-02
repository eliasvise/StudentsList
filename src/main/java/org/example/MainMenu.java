package org.example;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {
    private StudentFileList studentFileList = new StudentFileList(); // Create an instance

    public static void main(String[] args) {
        MainMenu menu = new MainMenu(); // Create an instance of MainMenu
        menu.MainMenu(); // Call the menu method on the instance
    }

            public void MainMenu () {
                StudentFileList studentFileList = new StudentFileList();
                Scanner scanner = new Scanner(System.in);
                //Menu principal
                System.out.println("Select an option.\n 1. Add New Student. \n 2. Verify existing Student. \n 3. Modify Student. \n 4. Delete Student. \n 5. Extract student. \n 6. Show Students. \n 7. Exit");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addStudent();
                        MainMenu();
                        break;
                    case 2:
                        verifyStudents();
                        MainMenu();
                        break;
                    case 3:
                        modifyStudent();
                        MainMenu();
                        break;
                    case 4:
                        deleteStudent();
                        MainMenu();
                        break;
                    case 5:
                        extractStudent();
                        MainMenu();
                        break;
                    case 6:
                        showStudents();
                        MainMenu();
                        break;
                    case 7:
                        System.out.println("You have leave the program");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOption not supported, please try again below.\n\n");
                        MainMenu();
                        break;
                }
            }


            public void addStudent () {
                //Get Student info
                Scanner scanner = new Scanner(System.in);
                System.out.println("Student Name: ");
                String studentName = scanner.nextLine();
                System.out.println("Student id: ");
                int id = scanner.nextInt();

                if (!studentFileList.exists(id)) {
                    studentFileList.addStudent(new Student(studentName, id));
                } else {
                    System.out.println("Student with id: " + id + "already exists, please try again with other id.");
                    addStudent();
                }
            }

            private void verifyStudents () {
                //Get Student info
                Scanner scanner = new Scanner(System.in);
                System.out.println("Student id to verify: ");
                int id = scanner.nextInt();
                System.out.println("Exist: " + studentFileList.exists(id));

            }

            private void modifyStudent () {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Insert the new Student Name: ");
                String studentName = scanner.nextLine();
                System.out.println("Insert the id of the student to modify");
                int id = scanner.nextInt();

                studentFileList.modify(new Student(studentName, id));
            }

            private void deleteStudent () {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Insert the Id of the student be deleted");
                int id = scanner.nextInt();

                studentFileList.delete(id);
            }

            private void extractStudent () {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Insert the Id of the student be deleted");
                int id = scanner.nextInt();

                studentFileList.extract(id);
            }

            private void showStudents() {
                this.studentFileList.showStudentList();
            }
}


