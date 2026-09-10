package Behavioral.Memento.Game;

import Behavioral.Mediator.AirTrafficControl.Plane;

public class Program {
    public static void main(String[] args) {
        Player player = new Player(1,100,500);

        Caretaker caretaker = new Caretaker();

        player.showState();
        System.out.println("-------------");

        caretaker.save(player.save());

        player.play();
        player.showState();
        System.out.println("-------------");

        Memento savedState = caretaker.undo();

        player.restore(savedState);
        player.showState();
    }
}
