package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess {

    public void process(Orderable item) {

        stepBefore();
        action(item);
        stepAfter();
    }

    public void stepBefore() {
        ConsoleProgressBar.run();
    }

    public void stepAfter() {
        System.out.println("Ending process!");
    }

    protected abstract void action(Orderable item);
}
