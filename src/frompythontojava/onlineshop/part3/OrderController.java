package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Basket;
import frompythontojava.onlineshop.part2.*;

public class OrderController {

    private PaymentProcess paymentProcess;
    private CheckoutProcess checkoutProcess;
    private OrderContainer orderContainer;
    private ShopView view;

    OrderController() {
        this.paymentProcess = new PaymentProcess();
        this.checkoutProcess = new CheckoutProcess();
        this.orderContainer = new OrderContainer();
        this.view = new ShopView();
    }

    public void payForOrder(Basket basket) {

        if (basket.getProductList().isEmpty()) {
            view.displayBasketIsEmptyMessage();
        } else {
            Order order = new Order();
            order.addBasket(basket);
            view.displayCheckoutMessage();
            this.checkoutProcess.process(order);
            view.displayPaymentMessage();
            this.paymentProcess.process(order);
            this.orderContainer.addOrder(order);
            view.displayOrderStatusChangedToPayed();
        }
    }

    public void displayAllOrders() {

        view.displayAllOrders(orderContainer.getOrders());
    }
}
