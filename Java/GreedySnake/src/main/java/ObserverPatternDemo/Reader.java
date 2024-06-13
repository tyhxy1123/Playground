package ObserverPatternDemo;

public class Reader implements IObserve{
    @Override
    public void update() {
        System.out.println("Reader received newspaper!");
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        NewspaperAgency agency = new NewspaperAgency();
        agency.subscribeObserver(reader);
        agency.notifyObservers();
    }
}
