package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Banca Transilvania");
        bank.addBranch("Roman");
        bank.addCustomer("Roman", "Antal Sergiu", 50.55);
        bank.addCustomer("Roman", "Mihai Tapu", 152.35);
        bank.addCustomer("Roman", "Geman Dorin", 124.25);

        bank.addBranch("Cluj-Napoca");
        bank.addCustomer("Cluj-Napoca", "Ion Vasile", 312.31);

        bank.addCustomerTransaction("Roman","Antal Sergiu",12.25);
        bank.addCustomerTransaction("Roman","Antal Sergiu",22.65);
        bank.addCustomerTransaction("Roman","Antal Sergiu",512.75);
        bank.addCustomerTransaction("Roman","Antal Sergiu",-98.132);

        bank.listCustomers("Roman",true,true);
        bank.listCustomers("Cluj-Napoca",true,false);
    }
}
