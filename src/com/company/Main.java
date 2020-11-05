package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
//    private static Visit visit;
    public static void main(String[] args) {
        System.out.print("Please enter customer's name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();

        Customer customer = new Customer(name);
        Visit visit = new Visit(customer);

        if (!customer.isMember()){
            System.out.print("Set a membership type: ");
            customer.setMemberType(scanner.nextLine());
        }

        visit.setServiceExpense();
        visit.setProductExpense();
        visit.printTotalExpense();
        
    }
    
    
    
    public void oldMethod(){
        Scanner scanner = new Scanner(System.in);
        float serviceDiscount = 0;
        int productDiscount;

        System.out.print("Enter 1)Premium - 2)Gold - 3) Silver: ");
        int membership = scanner.nextInt();
        scanner.nextLine();

        switch (membership){
            case 1:
                serviceDiscount = 0.20F;
                break;
            case 2:
                serviceDiscount = 0.15F;
                break;
            case 3:
                serviceDiscount = 0.10F;
                break;
        }

        System.out.println(serviceDiscount);

        System.out.println("\nEnter PRODUCTS prices: \n\t Enter (-1) when finished :");
        int i=0;
        float productsSum = 0;
        float product;
        while (true){
            System.out.print(++i + ") ");
            product = Float.parseFloat(scanner.nextLine());
            if (product == -1.0)    { i=0; break; }
            productsSum += product;

            System.out.println("Total= "+ NumberFormat.getCurrencyInstance().format(productsSum));

        }

        System.out.println("\nEnter SERVICES prices: \n\t Enter (-1) when finished :");

        float service, servicesSum = 0;
        while (true){
            System.out.print(++i + ") ");
            service = Float.parseFloat(scanner.nextLine());
            if (service == -1.0)
                break;
            servicesSum += service;

            System.out.println("Total= "+ NumberFormat.getCurrencyInstance().format(servicesSum));

        }
    }
}
