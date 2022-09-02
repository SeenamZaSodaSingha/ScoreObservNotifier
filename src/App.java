import java.util.Scanner;

import Client.Observer;
import Server.ScoreServer;
import Server.Source;
public class App {
    public static void main(String[] args) {
        Observer obv1 = new Observer();
        Observer obv2 = new Observer();
        ScoreServer server = new ScoreServer();
        Source src = new Source(server);

        src.registerObserver(obv1);
        src.registerObserver(obv2);

        Scanner sc = new Scanner(System.in);

        String score = "";
        do{
            System.out.print("Enter score: ");
            score = sc.nextLine();
            if(score.isEmpty()) break;
            server.setScore(score);
            src.notifyObservers();
        } while(true);
        sc.close();
    }
}
