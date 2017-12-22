package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess {

    public void process(Orderable item) {

        stepBefore();
        action(item);
        stepAfter();
    }

    public void stepBefore() {

    }

    public void stepAfter() {

    }

    protected abstract void action(Orderable item);
}
