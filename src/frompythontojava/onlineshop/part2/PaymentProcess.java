package frompythontojava.onlineshop.part2;

public class PaymentProcess extends AbstractProcess {

    @Override
    protected void action(Orderable item) {
        item.pay();
    }
}
