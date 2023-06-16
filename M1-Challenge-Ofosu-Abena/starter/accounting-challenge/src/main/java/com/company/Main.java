package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.company.Customer;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    private static List<Customer> newCustomerData = new ArrayList<>();

    private static int isInNewCustomer(int id, List<Customer> newCustomerData) {
        if (newCustomerData.isEmpty()) {
            return -1;
        }  else {
            int i = 0;
            for (Customer customer : newCustomerData) {
                i = i + 1;
                if (id == customer.getId()) {
                    return i;
                }
            }
        }
        return -1;
    }


    private static List<Customer> signedAccounts(List<Customer> newCustomerData, String sign) {
        // create accounts arraylist
        List<Customer> accounts = new ArrayList<>();
        for (Customer myCustomer : newCustomerData) {
            // add customer to arraylist if positive or negative account
            if (myCustomer.getBalance() >= 0 && sign == "positive") {
                accounts.add(myCustomer);
            } else if (myCustomer.getBalance() < 0 && sign == "negative") {
                accounts.add(myCustomer);
            }
        }
        return accounts;
    }


    public static void main(String[] args) {
        for (String[] customer : customerData) {
            int customerIndex = isInNewCustomer(Integer.parseInt(customer[0]),newCustomerData);

            //initialize charge and date
            AccountRecord record = new AccountRecord();
            record.setCharge(Integer.parseInt(customer[2]));
            record.setChargeDate(customer[3]);

            if (customerIndex == -1) {
                //create new customer if customer not in newCustomerData
                Customer newCustomer = new Customer();
                newCustomer.setName((customer[1]));
                newCustomer.setId(Integer.parseInt(customer[0]));

                newCustomer.getCharges().add(record);
                newCustomerData.add(newCustomer);
            } else {
                //add charge and date
                newCustomerData.get(customerIndex-1).getCharges().add(record);
            }
        }

        System.out.println("Positive accounts:" + signedAccounts(newCustomerData, "positive"));
        System.out.println("Negative accounts:" + signedAccounts(newCustomerData, "negative"));

    }
}
