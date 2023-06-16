package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {

    Customer customer1;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    void setUp() {
        customer1 = createCustomer(1, "Abena Ofosu");
        customer2 = createCustomer(2, "Natanyah Osei");
        customer3 = createCustomer(3, "Aliyah Mensah");

        AccountRecord firstRecord = createRecord(240, "2023-05-07");
        AccountRecord secondRecord = createRecord(170, "2023-06-05");
        AccountRecord thirdRecord = createRecord(-700, "2023-07-05");

        customer1.getCharges().add(firstRecord);
        customer2.getCharges().add(firstRecord);
        customer2.getCharges().add(secondRecord);
        customer3.getCharges().add(firstRecord);
        customer3.getCharges().add(secondRecord);
        customer3.getCharges().add(thirdRecord);
    }


    private Customer createCustomer(int id, String name) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        return customer;
    }


    private AccountRecord createRecord(int charge, String chargeDate) {
        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setCharge(charge);
        accountRecord.setChargeDate(chargeDate);
        return accountRecord;
    }


    @Test
    void getBalance() {
        assertEquals(240,customer1.getBalance());
        assertEquals(410,customer2.getBalance());
        assertEquals(-290,customer3.getBalance());
    }

    // negs

    @Test
    void testToString() {
        assertEquals(
                "Customer ID: 1\n" +
                        "Customer Name: Abena Ofosu\n" +
                        "Balance: 240",
                customer1.toString()
        );

        assertEquals(
                "Customer ID: 3\n" +
                        "Customer Name: Aliyah Mensah\n" +
                        "Balance: -290",
                customer3.toString()
        );
    }
}