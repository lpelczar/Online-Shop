package frompythontojava.onlineshop.part2;

public class CheckoutProcess extends AbstractProcess {

    @Override
    protected void action(Orderable item) {
        System.out.println("Change order status to: checked");
        item.checkout();
    }
}
