package ObserverPatternDemo;

import java.util.LinkedList;
import java.util.List;

public class NewspaperAgency implements ISubject {
    private List<IObserve> subscribers = new LinkedList<>();

    @Override
    public void subscribeObserver(IObserve obs) {
        subscribers.add(obs);
    }

    @Override
    public void removeObserver(IObserve obs) {
        if(obs != null && subscribers.contains(obs)){
            subscribers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        subscribers.forEach(IObserve::update);
    }
}
