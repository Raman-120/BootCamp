package Day1;

import java.util.Scanner;

public class StudentInformationSystem {
    public static void main(String[] args){

        // A student management system

        Scanner scanner = new Scanner(System.in);
        String name;
        double marks;
        int age;
        int i;
        double sum = 0;

        System.out.print("Enter the name of the student: ");
        name = scanner.nextLine();

        System.out.print("Enter the grade of the student: ");
        age = scanner.nextInt();

        for(i = 1; i <= 5; i++) {
            System.out.print("Enter the number of sub" + i + ": ");
            marks = scanner.nextDouble();
            sum += marks;
        }

        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Age: " +  age);
        System.out.println();

        System.out.println("****RESULT****");
        System.out.println("Your total obtained marks is : " + sum);

        double percentage = percentage(sum);

        System.out.printf("Your total obtained percentage is : %.2f", percentage);
        System.out.println();
        System.out.println();

        if(percentage >= 40){
            System.out.println("Result : Pass");
        }
        else{
            System.out.println("Result : Fail");
        }


        scanner.close();
    }

    static double percentage(double marks){
        return marks /500 * 100;
    }
}
