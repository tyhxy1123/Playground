package ObserverPatternDemo;

public interface ISubject {
    void subscribeObserver(IObserve obs);
    void removeObserver(IObserve obs);
    void notifyObservers();
}
