import java.util.Scanner;

public class SimpleStudentManagementSystem {
    public static void main(String[] args){

        String studentName;
        String email;
        int id;
        int age;
        String course;
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        do{
            System.out.println("1. Add a Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search student");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> studentManagement.addStudent();

                case 2 -> studentManagement.displayStudent();

                case 3 -> studentManagement.searchStudent();

                case 4 -> System.out.println("Thanks for using the app.");

                default -> System.out.println("Invalid input");
            }


        } while (choice != 4);
    }

}
