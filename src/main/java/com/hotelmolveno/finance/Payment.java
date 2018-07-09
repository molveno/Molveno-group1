package com.hotelmolveno.finance;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceNumber;
    private double paymentAmount;

    @ManyToOne
    private Bill bill;

    public Payment(){};

    public Payment(double paymentAmount) {
       this.paymentAmount = paymentAmount;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "invoiceNumber=" + invoiceNumber +
                ", paymentAmount=" + paymentAmount +
                '}';
    }


}






