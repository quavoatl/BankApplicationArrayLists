package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }


    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    public Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions, boolean currentBalance) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            System.out.println("\nCustomers for branch: " + existingBranch.getName()
                    + ", bank: " + this.name);
            ArrayList<Customers> branchCustomers = existingBranch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customers branchCustomer = branchCustomers.get(i);
                System.out.println("\n" + (i + 1) + ". Customer : " + branchCustomer.getName());

                if (showTransactions == true) {
                    System.out.println("Transactions :");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++)
                        System.out.println((j + 1) + ". Transaction amount: " + transactions.get(j) + " lei");

                    if (currentBalance == true) {
                        double finalBalance = 0;
                        for (int k = 0; k < transactions.size(); k++) {
                            finalBalance += transactions.get(k);
                        }
                        System.out.print("Current balance: " + new DecimalFormat("#.###").format(finalBalance) + " lei");
                    }
                }
            }
            return true;
        }
        return false;
    }


}

