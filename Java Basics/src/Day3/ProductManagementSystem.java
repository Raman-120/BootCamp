package Day3;

import java.io.*;
import java.util.*;

public class ProductManagementSystem implements Serializable {
    static File electronicsFile = new File("Electronics.ser");
    static File clothingFile = new File("Clothes.ser");
    @Serial
    private static final long serialVersionUID = 1L;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        List<Product> electronics = loadProduct(electronicsFile);
        List<Product> clothing = loadProduct(clothingFile);
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

            try{
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1 -> {

                        loadProduct(electronicsFile);
                        loadProduct(clothingFile);

                        System.out.print("Enter the product Category: ");
                        String productCategory = scanner.nextLine().toLowerCase();
                        if(productCategory.isEmpty()){
                            System.out.println("Product category can't be empty");
                        }


                        if(productCategory.equals("electronics")){
                            System.out.print("Enter the product ID: ");
                            int productId = scanner.nextInt();
                            if(productId < 0){
                                System.out.println("Product can't be in negative.");
                                break;
                            }
                            scanner.nextLine();

                            System.out.print("Enter the product name: ");
                            String productName = scanner.nextLine();
                            if(productName.isEmpty()){
                                System.out.println("Product Name can't be empty.");
                                break;
                            }

                            System.out.print("Enter the product price: ");
                            double productPrice = scanner.nextDouble();
                            if(productPrice < 0){
                                System.out.println("Prices can't be in negative.");
                                break;
                            }
                            scanner.nextLine();

                            System.out.print("Enter the product quantity: ");
                            int productQuantity = scanner.nextInt();
                            if(productQuantity < 0){
                                System.out.println("Quantity can't be in negative");
                                break;
                            }
                            scanner.nextLine();

                            electronics.add(new Product(productId, productName,productCategory, productPrice, productQuantity));
                            saveProduct(electronics, electronicsFile);
                        }
                        else if(productCategory.equals("clothing")){
                            System.out.print("Enter the product ID: ");
                            int productId = scanner.nextInt();
                            if(productId < 0){
                                System.out.println("Product can't be in negative.");
                                break;
                            }
                            scanner.nextLine();

                            System.out.print("Enter the product name: ");
                            String productName = scanner.nextLine();
                            if(productName.isEmpty()){
                                System.out.println("Product name can't be empty.");
                                break;
                            }

                            System.out.print("Enter the product price: ");
                            double productPrice = scanner.nextDouble();
                            if(productPrice < 0){
                                System.out.println("Price can't be in negative.");
                                break;
                            }
                            scanner.nextLine();

                            System.out.print("Enter the product quantity: ");
                            int productQuantity = scanner.nextInt();
                            if(productQuantity < 0){
                                System.out.println("Product Quantity can't be in negative.");
                                break;
                            }
                            scanner.nextLine();
                            clothing.add(new Product(productId, productName,productCategory, productPrice, productQuantity));
                            saveProduct(clothing, clothingFile);
                        }

                        else{
                            System.out.println("This category isn't available at the moment.");
                            break;
                        }

                        System.out.println("Product added successfully");
                    }

                    case 2 -> {

                        loadProduct(electronicsFile);
                        loadProduct(clothingFile);

                        System.out.println("\n******************");
                        //view all products of electronics category
                        i = electronics.iterator();
                        while (i.hasNext()){
                            product = i.next();
                            System.out.println(product);
                        }
                        System.out.println("******************\n");


                        System.out.println("\n******************");
                        // view all products of clothing category
                        i = clothing.iterator();
                        while (i.hasNext()){

                            product = i.next();
                            System.out.println(product);
                        }
                        System.out.println("******************");

                    }


                    case 3 -> {

                        loadProduct(electronicsFile);
                        loadProduct(clothingFile);

                        System.out.print("Enter the productID: ");
                        int productId = scanner.nextInt();
                        if(productId < 0){
                            System.out.println("Product can't be in negative.");
                            break;
                        }
                        scanner.nextLine();

                        System.out.print("Enter the product category: ");
                        String productCategory = scanner.nextLine().toLowerCase();
                        if(productCategory.isEmpty()){
                            System.out.println("product category can't be empty.");
                            break;
                        }

                        boolean found = false;
                        if(productCategory.equals("electronics")){
                            i = electronics.iterator();
                            while (i.hasNext()){
                                product = i.next();
                                if(productId == product.getProductId()){
                                    System.out.println("\n******************");
                                    System.out.println(product);
                                    System.out.println("******************\n");
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
                                    System.out.println("\n******************");
                                    System.out.println(product);
                                    System.out.println("******************\n");
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

                        loadProduct(electronicsFile);
                        loadProduct(clothingFile);

                        System.out.print("Enter the category: ");
                        String productCategory = scanner.nextLine().toLowerCase();
                        if(productCategory.isEmpty()){
                            System.out.println("Product category can't be emptied.");
                            break;
                        }

                        System.out.print("Enter the productId: ");
                        int productId = scanner.nextInt();
                        if(productId < 0){
                            System.out.println("Product ID can't be in negative.");
                            break;
                        }
                        scanner.nextLine();

                        boolean found = false;

                        if(productCategory.equals("electronics")){
                            i = electronics.iterator();
                            while (i.hasNext()){
                                product = i.next();
                                if(productId == product.getProductId()){
                                    System.out.print("Enter the new productId: ");
                                    int newProductId = scanner.nextInt();
                                    if(newProductId < 0){
                                        System.out.println("Product ID can't be in negative.");
                                        break;
                                    }
                                    scanner.nextLine();

                                    System.out.print("Enter the new product name: ");
                                    String productName = scanner.nextLine();
                                    if(productName.isEmpty()){
                                        System.out.println("Product name can't be empty.");
                                    }

                                    System.out.print("Enter the new price: ");
                                    double productPrice = scanner.nextDouble();
                                    if(productPrice < 0){
                                        System.out.println("Product price can't be in negative.");
                                        break;
                                    }
                                    scanner.nextLine();

                                    System.out.print("Enter the new Quantity: ");
                                    int productQuantity = scanner.nextInt();
                                    if(productQuantity < 0){
                                        System.out.println("Product Quantity can't be in negative.");
                                        break;
                                    }
                                    scanner.nextLine();

                                    found = true;
                                    product.setProductId(newProductId);
                                    product.setName(productName);
                                    product.setPrice(productPrice);
                                    product.setQuantity(productQuantity);

                                    Product updatedProduct = new Product(newProductId, productName,productCategory,
                                            productPrice, productQuantity);
                                    saveUpdatedProduct(updatedProduct, electronicsFile);

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
                                    if(newProductId < 0){
                                        System.out.println("Product ID can't be in negative.");
                                        break;
                                    }
                                    scanner.nextLine();

                                    System.out.print("Enter the new product name: ");
                                    String productName = scanner.nextLine();
                                    if(productName.isEmpty()){
                                        System.out.println("Product name can't be empty.");
                                        break;
                                    }

                                    System.out.print("Enter the new price: ");
                                    double productPrice = scanner.nextDouble();
                                    if(productPrice < 0){
                                        System.out.println("Product price can't be in negative.");
                                        break;
                                    }
                                    scanner.nextLine();

                                    System.out.print("Enter the new Quantity: ");
                                    int productQuantity = scanner.nextInt();
                                    if(productQuantity < 0){
                                        System.out.println("Product Quantity can't be in negative.");
                                        break;
                                    }
                                    scanner.nextLine();

                                    found = true;
                                    product.setProductId(newProductId);
                                    product.setName(productName);
                                    product.setPrice(productPrice);
                                    product.setQuantity(productQuantity);

                                    Product updatedProduct = new Product(newProductId, productName, productCategory,
                                            productPrice, productQuantity);
                                    saveUpdatedProduct(updatedProduct, clothingFile);

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

                        loadProduct(electronicsFile);
                        loadProduct(clothingFile);

                        System.out.print("Enter the product category: ");
                        String productCategory = scanner.nextLine().toLowerCase();
                        if(productCategory.isEmpty()){
                            System.out.println("Product category can't be empty.");
                            break;
                        }

                        System.out.print("Enter the product Id: ");
                        int productId = scanner.nextInt();
                        if(productId < 0){
                            System.out.println("Product ID can't be in negative.");
                            break;
                        }
                        scanner.nextLine();

                        boolean found = false;
                        if(productCategory.equals("electronics")){
                            i = electronics.iterator();
                            while (i.hasNext()){
                                product = i.next();
                                if(productId == product.getProductId()){
                                    i.remove();
                                    found = true;
                                    saveProduct(electronics, electronicsFile);
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
                                    saveProduct(clothing, clothingFile);
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

                        loadProduct(electronicsFile);
                        loadProduct(clothingFile);

                        System.out.print("Enter the product category: ");
                        String productCategory = scanner.nextLine();
                        if(productCategory.isEmpty()){
                            System.out.println("Product category can't be empty.");
                            break;
                        }

                        System.out.print("Enter the product name: ");
                        String productName = scanner.nextLine();
                        if(productName.isEmpty()){
                            System.out.println("Product name can't be empty.");
                            break;
                        }

                        boolean found = false;
                        if(productCategory.equals("electronics")){

                            i = electronics.iterator();
                            while (i.hasNext()){
                                product = i.next();
                                if(productName.equals(product.getName())){
                                    System.out.println("\n******************");
                                    System.out.println(product);
                                    System.out.println("******************\n");
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
                                    System.out.println("\n******************");
                                    System.out.println(product);
                                    System.out.println("******************\n");
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
            } catch (InputMismatchException e){
                System.out.println("Invalid Input.");
            }

        }while (choice != 7);
        scanner.close();
    }

    @SuppressWarnings("Unchecked")
    static void saveUpdatedProduct(Product updatedProduct, File file){
        List<Product> products = loadProduct(electronicsFile);
        boolean found = false;

        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductId() == updatedProduct.getProductId()){
                products.set(i,updatedProduct);
                found = true;
                break;
            }
        }
        if(!found){
            products.add(updatedProduct); // adds new if not found
        }

        saveProduct(products, file);
    }

    @SuppressWarnings("Unchecked")
    static List<Product> loadProduct(File file){
        if(!file.exists()){
            return new ArrayList<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (List<Product>) ois.readObject();
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

    static void saveProduct(List<Product> products, File file){
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
