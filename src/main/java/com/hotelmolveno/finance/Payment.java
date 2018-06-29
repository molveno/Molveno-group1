package com.hotelmolveno.finance;

public class Payment {

    private static int nextInvoiceNumber = 1;
    private int InvoiceNumber;
    private double paymentAmount;



    public Payment(double paymentAmount) {
        this.InvoiceNumber = nextInvoiceNumber;
        nextInvoiceNumber++;
        this.paymentAmount = paymentAmount;
    }

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }
    public void setInvoiceNumber(int invoiceNumber) {
        InvoiceNumber = invoiceNumber;
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
                "InvoiceNumber=" + InvoiceNumber +
                ", paymentAmount=" + paymentAmount +
                '}';
    }

    public static void main(String[] args) {
        Payment payment1 = new Payment(100.00);
        Payment payment2 = new Payment(200);
        Payment payment3 = new Payment(300);

        Bill bill1 = new Bill();
        Bill bill2 = new Bill();
        Bill bill3 = new Bill();

        bill1.setBarCost(100);
        bill1.setRestaurantCost(200);
        bill1.calculateTotalCost();

        System.out.println(payment1);
        System.out.println(payment2);
        System.out.println(payment3);
        System.out.println(bill1.getTotalCost());
        }
    }






