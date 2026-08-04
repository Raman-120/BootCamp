package Day3;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import  java.util.Scanner;

public class ProductManagementSystem implements Serializable {
    static File file = new File("Info.ser");
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

                    System.out.print("Enter the product Category: ");
                    String productCategory = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();

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

                    System.out.println("Product added successfully");
                }

                case 2 -> {
                    //view all products of electronics category
                    System.out.println("******************");
                    i = electronics.iterator();
                    while (i.hasNext()){
                        product = i.next();
                        System.out.println(product);
                    }
                    System.out.println("******************");

                    // view all products of clothing category
                    i = clothing.iterator();
                    while (i.hasNext()){
                        product = i.next();
                        System.out.println(product);
                    }

                    System.out.println("******************");

                }


                case 3 -> {

                    System.out.print("Enter the productID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the product category: ");
                    String productCategory = scanner.nextLine().toLowerCase();

                    boolean found = false;
                    if(productCategory.equals("electronics")){
                        i = electronics.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productId == product.getProductId()){
                                System.out.println(product);
                                found = true;
                                break;
                            }
                        }
                    }
                    else if(productCategory.equals("clothing")){
                        i = clothing.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productId == product.getProductId()){
                                System.out.println(product);
                                found = true;
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("This category isn't available at the moment.");
                    }

                    if(!found){
                        System.out.println("Product isn't available at the moment.");
                    }

                }

                case 4 -> {

                    System.out.print("Enter the category: ");
                    String productCategory = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the productId: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;

                    if(productCategory.equals("electronics")){
                        i = electronics.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productId == product.getProductId()){
                                System.out.print("Enter the new productId: ");
                                int newProductId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter the new product name: ");
                                String productName = scanner.nextLine();

                                System.out.print("Enter the new price: ");
                                double productPrice = scanner.nextDouble();
                                scanner.nextLine();

                                System.out.print("Enter the new Quantity: ");
                                int productQuantity = scanner.nextInt();
                                scanner.nextLine();

                                found = true;
                                product.setProductId(newProductId);
                                product.setName(productName);
                                product.setPrice(productPrice);
                                product.setQuantity(productQuantity);

                                System.out.println("Product information updated successfully");

                                break;

                            }

                        }
                    }

                    else if(productCategory.equals("clothing")){
                        i = clothing.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productId == product.getProductId()) {
                                System.out.print("Enter the new productId: ");
                                int newProductId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter the new product name: ");
                                String productName = scanner.nextLine();

                                System.out.print("Enter the new price: ");
                                double productPrice = scanner.nextDouble();
                                scanner.nextLine();

                                System.out.print("Enter the new Quantity: ");
                                int productQuantity = scanner.nextInt();
                                scanner.nextLine();

                                found = true;
                                product.setProductId(newProductId);
                                product.setName(productName);
                                product.setPrice(productPrice);
                                product.setQuantity(productQuantity);


                                System.out.println("Product information updated successfully");
                                break;

                            }
                        }
                    }
                    else{
                        System.out.println("This category isn't available at the moment");
                    }

                    if(!found){
                        System.out.println("Product isn't available at the moment.");
                    }

                }

                case 5 -> {
                    System.out.print("Enter the product category: ");
                    String productCategory = scanner.nextLine().toLowerCase();

                    System.out.print("Enter the product Id: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    if(productCategory.equals("electronics")){
                        i = electronics.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productId == product.getProductId()){
                                i.remove();
                                found = true;
                                break;
                            }
                        }
                    }
                    else if (productCategory.equals("clothing")){
                        i = clothing.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productId == product.getProductId()){
                                i.remove();
                                System.out.println("Product removed successfully.");
                                found = true;
                                break;
                            }
                        }

                    }
                    else{
                        System.out.println("This category isn't available at the moment");
                    }

                    if(!found){
                        System.out.println("Product isn't available at the moment");
                    }

                }


                case 6 -> {
                    System.out.print("Enter the product category: ");
                    String productCategory = scanner.nextLine();

                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();

                    boolean found = false;
                    if(productCategory.equals("electronics")){

                        i = electronics.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productName.equals(product.getName())){
                                System.out.println(product);
                                found = true;
                                break;
                            }
                        }
                    }
                    else if(productCategory.equals("clothing")){
                        i = clothing.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            if(productName.equals(product.getName())){
                                System.out.println(product);
                                found = true;
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("This category isn't available at the moment.");
                    }

                }

                case 7 -> System.out.println("Exiting...\nThanks for using our service.");


                default -> System.out.println("Please choose a valid option.");
            }
        }while (choice != 7);
        scanner.close();
    }

    @SuppressWarnings("Unchecked")
    static void saveUpdatedProduct(){
        ArrayList<Product> products = loadProduct();
    }

    @SuppressWarnings("Unchecked")
    static ArrayList<Product> loadProduct(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (ArrayList<Product>) ois.readObject();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
            return new ArrayList<>();
        }
        catch (IOException e ){
            System.out.println("Cannot read the file");
            return new ArrayList<>();
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            return new ArrayList<>();
        }
    }

    static void saveProduct(ArrayList<Product> products){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(products);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch (IOException e){
            System.out.println("Cannot write on the file");
        }
        catch (Exception e){
            System.out.println("Error: "  + e.getMessage());
        }
    }
}
