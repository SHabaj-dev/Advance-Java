package CRUD_App;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        while(true){
            System.out.println("Please Select One Option");
            System.out.println("1 - Show Whole Table");
            System.out.println("2 - Read Data");
            System.out.println("3 - Insert Data");
            System.out.println("4 - Delete Data");
            System.out.println("0 - Exit");
            int choice = sc.nextInt();

            switch (choice){
                case 1 -> {
                    //Method to Display the Data;
                    dao.showTable();
                    System.out.println();
                }
                case 2 -> {
//                  Method to Show data by student Id.
                    System.out.println("Enter the Student Id");
                    int student_id = sc.nextInt();
                    dao.showData(student_id);
                    System.out.println();
                }

                case 3 -> {
                    System.out.println("Enter the Student Id, First Name, Last Name And Branch of the Student Sequentially ");
                    int student_id = sc.nextInt();
                    String first_name = sc.next();
                    String last_name = sc.next();
                    String branch = sc.next();
                    int rowsAffected = dao.insert(student_id, first_name, last_name, branch);
                    if(rowsAffected > 0){
                        System.out.println("Data Insertion Completed");
                        System.out.println("Total number of Rows Affected " + rowsAffected);
                    }else{
                        System.out.println("Inserting Data Failed !! Try Again");
                    }

                }

                case 4 -> {
                    System.out.println("Enter Student Id ");
                    int student_id = sc.nextInt();
                    int rowsAffected = dao.deleteData(student_id);
                    if(rowsAffected > 0){
                        System.out.println("Deletion Successful");
                    }else{
                        System.out.println("Something Went Wrong!! Please Try Again");
                    }
                }
                case 0 -> {
                    System.exit(0);
                }
            }
        }

    }

}
