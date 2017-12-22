package frompythontojava.onlineshop.part2;

public class PaymentProcess extends AbstractProcess {

    @Override
    protected void action(Orderable item) {
        System.out.println("Change order status to: payed");
        item.pay();
    }
}
