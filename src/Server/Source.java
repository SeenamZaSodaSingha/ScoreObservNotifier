package Server;

import Client.Observer;
import java.util.ArrayList;

public class Source {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    ScoreServer server;

    public Source(ScoreServer s) {
        server = s;
    }

    public void registerObserver(Observer obv) {
        observers.add(obv);
    }

    public void notifyObservers(){
        // System.out.println("SCORE FROM SERVER: " + server.getScore());
        for(Observer obv : observers){
            obv.update(server.getScore());
        }
    }
}
