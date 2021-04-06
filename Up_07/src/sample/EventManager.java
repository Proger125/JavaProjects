package sample;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    List<EventListener> listeners = new ArrayList<>();
    public void subscribe(EventListener listener){
        listeners.add(listener);
    }
    public void unsubscribe(EventListener listener){
        listeners.remove(listener);
    }
    public void not(String keyPressed){
        for (var listener : listeners){
            listener.update(keyPressed);
        }
    }
}
