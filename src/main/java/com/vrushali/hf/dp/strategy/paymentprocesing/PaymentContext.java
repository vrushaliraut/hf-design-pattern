package com.vrushali.hf.dp.strategy.paymentprocesing;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Inject strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.processPayment(amount);
    }

}
