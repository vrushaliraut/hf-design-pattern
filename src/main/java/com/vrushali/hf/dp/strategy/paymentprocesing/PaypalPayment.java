package com.vrushali.hf.dp.strategy.paymentprocesing;

public class PaypalPayment implements PaymentStrategy{

    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing paypal payment of $" + amount);
    }
}
