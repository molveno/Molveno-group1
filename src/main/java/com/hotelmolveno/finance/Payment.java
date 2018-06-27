package com.hotelmolveno.finance;

public class Payment {

    public static int invoiceNumber = 0;
    public long id;
    double paymentAmount;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Payment(double paymentAmount) {
        this.paymentAmount = paymentAmount;
           }

    public static int getInvoiceNumber() {
        return invoiceNumber;
    }

    public static void setInvoiceNumber(int invoiceNumber) {
        Payment.invoiceNumber = invoiceNumber;
    }

    public double getPayment() {
        return paymentAmount;
    }
    public void setPayment(double payment) {
        this.paymentAmount = payment;
    }



    public static void main(String[] args) {
        Payment payment1 = new Payment (100.00);
       // Payment.setId(++Payment.invoiceNumber);
        System.out.println(payment1.getPaymentAmount());

        }
    }






