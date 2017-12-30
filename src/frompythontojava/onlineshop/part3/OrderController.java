package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Basket;
import frompythontojava.onlineshop.part2.*;

import java.util.ArrayList;

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
            this.checkoutProcess.process(order);
            this.paymentProcess.process(order);
            this.orderContainer.addOrder(order);
            view.displayOrderStatusChangedToPayed();
        }
    }

    public void displayAllOrders() {

        view.displayAllOrders(orderContainer.getOrders());
    }
}
