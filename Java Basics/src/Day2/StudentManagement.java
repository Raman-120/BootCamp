package Day2;

import  java.util.Scanner;
import java.util.ArrayList;

public class StudentManagement {

    ArrayList<Student> students = new ArrayList<>();
    Scanner scanner= new Scanner(System.in);

    public void addStudent(){
        System.out.print("Enter the student Id: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student age: ");
        int  age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Student(studentID, name, email, age,course));

    }

    public void displayStudent(){
        for(Student student : students){
            System.out.println("********************");
            System.out.println(student);
        }
    }

    public void searchStudent(){
        System.out.print("Enter the student Id: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for(Student student : students){
            if(student.studentID == studentId){
                System.out.println(student);
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println(".Student not found.");
        }

    }

}
