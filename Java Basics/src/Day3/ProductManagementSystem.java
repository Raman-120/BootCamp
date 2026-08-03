package Day3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import  java.util.Scanner;

public class ProductManagementSystem {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        List<Product> electronics = new ArrayList<>();
        List<Product> clothing = new ArrayList<>();
        Iterator<Product> i;
        Product product;



        int choice = 0;

        do{
            System.out.println("*******************************");
            System.out.println("1. Add product");
            System.out.println("2. View all products");
            System.out.println("3. Search product by ID");
            System.out.println("4. Update product");
            System.out.println("5. Delete product");
            System.out.println("6. Search Product by Category");
            System.out.println("7. Exit");
            System.out.println("*******************************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.print("Enter the product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter the product Category: ");
                    String productCategory = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the product price: ");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter the product quantity: ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine();

                    if(productCategory.equals("electronics")){
                        electronics.add(new Product(productId, productName,productCategory, productPrice, productQuantity));
                    }
                    else{
                        clothing.add(new Product(productId, productName,productCategory, productPrice, productQuantity));
                    }
                }

                case 2 -> {
                    //view all products of electronics category
                    System.out.println("******************");
                    i = electronics.iterator();
                    while (i.hasNext()){
                        product = i.next();
                        System.out.println(product);
                    }

                    // view all products of clothing category
                    System.out.println("******************");
                    i = clothing.iterator();
                    while (i.hasNext()){
                        product = i.next();
                        System.out.println(product);
                    }

                }
                default -> System.out.println("Please choose a valid option.");
            }


        }while (choice != 7);

    }
}
