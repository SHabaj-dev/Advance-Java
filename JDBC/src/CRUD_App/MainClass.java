package CRUD_App;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        while(true){
            System.out.println("Please Selct One Option");
            System.out.println("1 - Show Whole Table");
            System.out.println("2 - Read Data");
            System.out.println("3 - Insert Data");
            System.out.println("4- Delete Data");
            System.out.println("5- Update Data");
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
            }
        }

    }

}
