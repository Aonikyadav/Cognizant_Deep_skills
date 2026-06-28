package WEEK1.DesignPattern.AdapterPatternExample;

public class Adaptee {


    public interface PaymentProcessor {
        void processPayment(double amount);
    }


    public static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of Rs. " + amount + " processed through PayPal Gateway.");
        }
    }

    public static class StripeGateway {
        public void payAmount(double amount) {
            System.out.println("Payment of Rs. " + amount + " processed through Stripe Gateway.");
        }
    }

    public static class RazorpayGateway {
        public void doPayment(double amount) {
            System.out.println("Payment of Rs. " + amount + " processed through Razorpay Gateway.");
        }
    }

    public static class PayPalAdapter implements PaymentProcessor {

        private PayPalGateway payPalGateway;

        public PayPalAdapter(PayPalGateway payPalGateway) {
            this.payPalGateway = payPalGateway;
        }

        public void processPayment(double amount) {
            payPalGateway.makePayment(amount);
        }
    }

    public static class StripeAdapter implements PaymentProcessor {

        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripeGateway.payAmount(amount);
        }
    }

    public static class RazorpayAdapter implements PaymentProcessor {

        private RazorpayGateway razorpayGateway;

        public RazorpayAdapter(RazorpayGateway razorpayGateway) {
            this.razorpayGateway = razorpayGateway;
        }

        public void processPayment(double amount) {
            razorpayGateway.doPayment(amount);
        }
    }
}