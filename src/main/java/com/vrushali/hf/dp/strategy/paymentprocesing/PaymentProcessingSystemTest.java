package com.vrushali.hf.dp.strategy.paymentprocesing;

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        //Pay using credit card
        paymentContext.setPaymentStrategy(new CreditCardPayment(
                "1234 5678 9012 3456", "John Doe", "12/24"));

        paymentContext.pay(100.00);

        // Pay using paypal
        paymentContext.setPaymentStrategy(new PaypalPayment("4XZ2g@example.com"));
        paymentContext.pay(50.00);

        // Pay using crypto
        paymentContext.setPaymentStrategy(new CryptoPayment("0x123456789012"));
        paymentContext.pay(10.00);
    }
}
