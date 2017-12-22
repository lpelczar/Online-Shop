package frompythontojava.onlineshop.part2;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        System.out.println("Status: " + order.getStatus());
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        PaymentProcess paymentProcess = new PaymentProcess();
        checkoutProcess.process(order);
        System.out.println("Status: " + order.getStatus());
        paymentProcess.process(order);
        System.out.println("Status: " + order.getStatus());
    }
}
