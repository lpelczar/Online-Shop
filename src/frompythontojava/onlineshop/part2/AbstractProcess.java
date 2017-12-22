package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess {

    public void process(Orderable item) {

        stepBefore();
        action(item);
        stepAfter();
    }

    public void stepBefore() {
        System.out.println("Starting action!");
    }

    public void stepAfter() {
        System.out.println("Ending action!");
    }

    protected abstract void action(Orderable item);
}
