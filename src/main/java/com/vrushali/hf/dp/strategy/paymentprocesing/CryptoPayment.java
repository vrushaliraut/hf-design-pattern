package com.vrushali.hf.dp.strategy.paymentprocesing;

public class CryptoPayment implements PaymentStrategy{
    private String WalletAddress;

    public CryptoPayment(String walletAddress) {
        WalletAddress = walletAddress;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of $" + amount);
    }
}
