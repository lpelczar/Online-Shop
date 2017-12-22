package frompythontojava.onlineshop.part2;

public class Main {

    public static void main(String[] args) {
	    Order order = new Order();
	    System.out.println(order.getStatus());
	    CheckoutProcess checkoutProcess = new CheckoutProcess();
	    PaymentProcess paymentProcess = new PaymentProcess();
	    checkoutProcess.action(order);
        System.out.println(order.getStatus());
	    paymentProcess.action(order);
        System.out.println(order.getStatus());
    }
}
