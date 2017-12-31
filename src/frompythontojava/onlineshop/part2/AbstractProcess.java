package frompythontojava.onlineshop.part2;

import frompythontojava.onlineshop.logs.ProcessLogger;

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
        ProcessLogger.log("Order processed!");
    }

    protected abstract void action(Orderable item);
}
