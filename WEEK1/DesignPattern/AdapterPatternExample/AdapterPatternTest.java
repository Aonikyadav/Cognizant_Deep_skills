package WEEK1.DesignPattern.AdapterPatternExample;

public class AdapterPatternTest {

    public static void main(String[] args) {

        Adaptee.PaymentProcessor pp =
                new Adaptee.PayPalAdapter(new Adaptee.PayPalGateway());

        pp.processPayment(3000);


        Adaptee.PaymentProcessor sp =
                new Adaptee.StripeAdapter(new Adaptee.StripeGateway());

        sp.processPayment(5500);


        Adaptee.PaymentProcessor rp =
                new Adaptee.RazorpayAdapter(new Adaptee.RazorpayGateway());

        rp.processPayment(2000);
    }
}