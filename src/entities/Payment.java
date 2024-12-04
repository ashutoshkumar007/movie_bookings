package entities;

import enums.PaymentStatus;

public class Payment {
    private final String  paymentId;
    private final float price;
    private PaymentStatus paymentStatus;

    public Payment(String paymentId,float price) {
        this.paymentId = paymentId;
        this.price = price;
        this.paymentStatus =PaymentStatus.PENDING;
    }

    public boolean processPayment() {
        System.out.println("Processing payment");
        boolean paymentSuccess = Math.random() >0.2;
        if(paymentSuccess){
            this.paymentStatus = PaymentStatus.SUCCESS;
            System.out.println("entities.Payment successful for amount "+price);
        }
        else {
            this.paymentStatus = PaymentStatus.FAILURE;
            System.out.println("entities.Payment failed for amount "+price);
        }
        return paymentSuccess;
    }
}
