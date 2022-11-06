package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        LinkedList products = new LinkedList();
        try {
            File myObj = new File("src/main/java/org/example/products.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                StringTokenizer tokenizer = new StringTokenizer(myReader.nextLine());
                String name = tokenizer.nextToken();
                Double buyingPrice = Double.parseDouble(tokenizer.nextToken());
                Double sellingPrice = Double.parseDouble(tokenizer.nextToken());
                int quantity = Integer.parseInt(tokenizer.nextToken());
                String ID = tokenizer.nextToken();
                Product p = new Product(name,buyingPrice,sellingPrice,quantity,ID);
                products.add(p);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Owner owner = new Owner(products);
        mainMenu(owner);
    }

    public static void mainMenu(Owner owner) throws IOException {
        FileWriter tWriter = new FileWriter("src/main/java/org/example/Transactions.txt",true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Main menu: "+ dtf.format(now)+"\n");
        System.out.println("1. Sell Product \n");
        System.out.println("2. Manage Inventory \n");
        System.out.println("3. Manage Products \n");
        System.out.println("4. Reports \n");
        System.out.println("5. Exit \n");
        Scanner sc1 = new Scanner(System.in);
        int option = sc1.nextInt();
        switch (option) {
            case 1 -> {
                Scanner sc11 = new Scanner(System.in);
                owner.printInv();
                String op1 = sc11.next();
                Product input = owner.getInv().contains(op1).getData();
                boolean temp =owner.sellProduct(op1);
                if(temp){
                    tWriter.write("item "+op1+" "+"sold for "+input.getSellingPrice()+" "+dtf.format(now) +"\n");
                }
                tWriter.close();
                mainMenu(owner);
            }
            case 2 -> {
                inventoryMenu(owner);
            }
            case 3 -> {
                productsMenu(owner);
            }
            case 4 -> {
                reportsMenu(owner);
            }
            case 5 -> {
                System.exit(0);
            }
        }

    }
    public static void inventoryMenu(Owner owner) throws IOException {
        FileWriter tWriter = new FileWriter("src/main/java/org/example/Transactions.txt",true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Inventory Menu \n");
        System.out.println("1. Add (buy) Product \n");
        System.out.println("2. Update Product in Inventory \n");
        System.out.println("3. Delete Product from Inventory \n");
        System.out.println("4. Return to Main Menu \n");
        int op = sc2.nextInt();
        switch (op){
            case 1 -> {
                owner.printProducts();
                Scanner sc21 = new Scanner(System.in);
                String input = sc21.next();
                Node<Product> tempNode = owner.getProducts().contains(input);
                boolean temp = owner.buyProduct(input);
                if(temp){
                    tWriter.write("item "+input+" "+"bought for "+tempNode.getData().getBuyingPrice()+" "+dtf.format(now)+"\n");
                }
                tWriter.close();
                inventoryMenu(owner);
            }
            case 2 ->{
                Scanner sc22 = new Scanner(System.in);
                System.out.println("which product you want to update ? \n");
                owner.printInv();
                String input = sc22.nextLine();
                Node<Product> temp = owner.getInv().contains(input);
                if(temp != null){
                    Scanner sc221 = new Scanner(System.in);
                    System.out.println("What do you want to update ? \n");
                    System.out.println("1-Change the selling price \n");
                    System.out.println("2-Change the quantity \n");
                    System.out.println("3-Return to the inventory menu \n");
                    int option = sc221.nextInt();
                    switch (option){
                        case 1 ->{
                            Scanner sc2211 = new Scanner(System.in);
                            System.out.println("please enter the desired price \n");
                            Double ans = sc2211.nextDouble();
                            temp.getData().setSellingPrice(ans);
                            inventoryMenu(owner);
                        }
                        case 2 ->{
                            Scanner sc2212 = new Scanner(System.in);
                            System.out.println("please enter the new quantity value \n");
                            int ans2 = sc2212.nextInt();
                            temp.getData().setQuantity(ans2);
                            tWriter.write(input + "'s"+" quantity has been changed to"+" "+ans2+dtf.format(now)+"\n");
                            tWriter.close();
                            inventoryMenu(owner);
                        }
                        case 3 ->{
                            inventoryMenu(owner);
                        }
                    }
                }
            }
            case 3 ->{
                Scanner sc23 = new Scanner(System.in);
                System.out.println("Select the item you want to delete");
                owner.printInv();
                String ans = sc23.nextLine();
                owner.getInv().deleteProduct(ans);
                tWriter.write("item "+ans+" has been deleted"+dtf.format(now)+"\n");
                tWriter.close();
                inventoryMenu(owner);
            }
            case 4 -> {
                mainMenu(owner);
            }
        }
    }
    public static void productsMenu(Owner owner) throws IOException {
        Scanner sc3 = new Scanner(System.in);
        FileWriter tWriter = new FileWriter("src/main/java/org/example/Transactions.txt",true);
        FileWriter pWriter = new FileWriter("src/main/java/org/example/products.txt4",true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Manage Products Menu: \n");
        System.out.println("""
                1. Print all products
                2. Add new Product
                3. Remove Product
                4. Update Product
                5. Return to Main Menu
                Option:""");
        int option = sc3.nextInt();
        switch (option){
            case 1 ->{
                owner.printProducts();
                productsMenu(owner);
            }
            case 2 ->{
                Scanner sc32 = new Scanner(System.in);
                System.out.println("please enter the name of the product");
                String name = sc32.nextLine();
                System.out.println("please enter the Buying price of the product");
                Double buyingPrice = sc32.nextDouble();
                System.out.println("please enter the Selling price of the product");
                Double sellingPrice = sc32.nextDouble();
                System.out.println("please enter the amount of products you want to add");
                int quantity = sc32.nextInt();
                System.out.println("please enter an ID for the product");
                String ID = sc32.next();
                Product p = new Product(name,buyingPrice,sellingPrice,quantity,ID);
                owner.addProduct(p);
                pWriter.write(name+" "+buyingPrice+" "+sellingPrice+" "+quantity+" "+ID+"\n");
                pWriter.close();
                productsMenu(owner);
            }
            case 3 ->{
                Scanner sc33 = new Scanner(System.in);
                System.out.println("please enter the name of the product you want to delete");
                String temp = sc33.nextLine();
                owner.getProducts().deleteProduct(temp);
                pWriter.write("Product "+temp+" has been deleted"+dtf.format(now)+"\n");
                tWriter.close();
                productsMenu(owner);
            }
            case 4 ->{
                Scanner sc34 = new Scanner(System.in);
                System.out.println("which product you want to update ? \n");
                owner.printProducts();
                String input = sc34.nextLine();
                Node<Product> temp = owner.getProducts().contains(input);
                if(temp != null){
                    System.out.println("What do you want to update ? \n");
                    System.out.println("1-Change the selling price \n");
                    System.out.println("2-Change the quantity \n");
                    System.out.println("3-Return to the products menu \n");
                    int op = sc34.nextInt();
                    switch (op){
                        case 1 ->{
                            System.out.println("please enter the desired price \n");
                            Double ans = sc34.nextDouble();
                            temp.getData().setSellingPrice(ans);
                            productsMenu(owner);
                        }
                        case 2 ->{
                            Scanner sc342 = new Scanner(System.in);
                            System.out.println("please enter the new quantity value \n");
                            int ans2 = sc342.nextInt();
                            temp.getData().setQuantity(ans2);
                            tWriter.write(input + "'s"+" quantity has been changed to"+" "+ans2+dtf.format(now)+"\n");
                            tWriter.close();
                            productsMenu(owner);
                        }
                        case 3 ->{
                            productsMenu(owner);
                        }
                    }
                }
            }
            case 5 ->{
                mainMenu(owner);
            }
        }
    }
    public static void reportsMenu(Owner owner) throws FileNotFoundException {
        FileReader pReader = new FileReader("src/main/java/org/example/Transactions.txt");
        System.out.println("""
                Report Menu
                1. Print a list of product names that are sold between two time period
                2. Print the name of the Best Selling Product
                3. Print list of products sold on specified Month (Jan, Feb, etc.)
                4. Print all products sold on specified week day (Mon, Tue, Wed, etc.)
                5. Return to Main Menu
                Option:""");
    }
}