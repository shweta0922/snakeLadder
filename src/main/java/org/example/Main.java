package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scan = new Scanner(System.in);
        int noOfSnakes = scan.nextInt();
        List<Snake> snakes = new ArrayList<Snake>();
        List<Ladder> ladders = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        while(noOfSnakes>0){
            snakes.add(new Snake(scan.nextInt(), scan.nextInt()));
            noOfSnakes--;
        }
        int noOfLadders = scan.nextInt();
        while(noOfLadders>0){
            ladders.add(new Ladder(scan.nextInt(), scan.nextInt()));
            noOfLadders--;
        }
        int noOfPlayers = scan.nextInt();
        int i=0;
        while(noOfPlayers>0){
            String playerName = scan.next();
            players.add(i++, new Player(playerName, scan.nextInt()-1));
            noOfPlayers--;
        }
        GameSession playGame = new GameSession(snakes, ladders, players);
        playGame.startGame();
    }
}
