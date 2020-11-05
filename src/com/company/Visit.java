package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Visit {
    String name;
    //    private Date date = new Date();
    public Visit(Customer customer) {
        this.customer=customer;
//        this.name = name;
//        this.date = date;
    }

    Customer customer = new Customer(name);

    private double serviceExpense;
    private double productExpense;
    Scanner scanner = new Scanner(System.in);

    private int i = 0;

    public void setServiceExpense() {
        System.out.println("Enter all SERVICE expenses: \t(enter -1 to quit)");
        double serviceExpense;
        i=0;
        while (true){
            System.out.print(++i + ") ");
            serviceExpense = Double.parseDouble(scanner.nextLine());
            if (serviceExpense == -1)
                break;
            this.serviceExpense += serviceExpense;
        }
    }

    public void setProductExpense() {
        System.out.println("Enter all PRODUCT expenses: \t(enter -1 to quit)");
        double productExpense;
        i=0;
        while (true){
            System.out.print(++i + ") ");
            productExpense = Double.parseDouble(scanner.nextLine());
            if (productExpense == -1)
                break;
            this.productExpense += productExpense;
        }
    }

    private double getServiceExpense() {
        // Total Service expense after discount

        serviceExpense = serviceExpense * (1 - DiscountRate.getServiceDiscountRate(customer.getMemberType()));
        return serviceExpense;
    }

    private double getProductExpense() {
        // Total PRODUCT expense after discount

        productExpense = productExpense * (1 - DiscountRate.getProductDiscountRate(customer.getMemberType()));
        return productExpense;
    }

    public void printTotalExpense() {
        double totalExpense = getProductExpense() + getServiceExpense();
        System.out.println("\n-----------------------");
        System.out.println("Total= " + NumberFormat.getCurrencyInstance().format(totalExpense));
    }
}
