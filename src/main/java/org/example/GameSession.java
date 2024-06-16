package org.example;

import java.util.*;

public class GameSession {
    int id;
    List<Player> players;
    Map<Integer, Integer> snakeAndLadder = new HashMap<Integer, Integer>();
    int currentTurn;
    int winner;

    public GameSession(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        this.players = players;
        for (Ladder ladder : ladders) {
            snakeAndLadder.put(ladder.getStart(), ladder.getEnd());
        }
        for (Snake snake : snakes) {
            snakeAndLadder.put(snake.getStart(), snake.getEnd());
        }
        this.currentTurn = 0;
        this.winner = -1;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public Map<Integer, Integer> getSnakeAndLadder() {
        return snakeAndLadder;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public void startGame(){
//        if(winner != -1 || value > 6 || value < 1 || players.get(currentTurn).getId() == player.getId()){
//            return -1;
//        }
        setPlayersPosition();
        int i = -1;
        Random random = new Random();
        do{
            i++;
            i = i%players.size();
            setCurrentTurn(i);
            StringBuilder sb = new StringBuilder();
            Player currentPlayer = players.get(currentTurn);
            sb.append(currentPlayer.getName());
            int diceNumber =  random.nextInt(6) + 1;
            int nextPosition = currentPlayer.getPosition() + diceNumber;
            if(isNextPositionLessThan100(nextPosition)){
                sb.append(" rolled a ").append(diceNumber);

            }
            boolean isSnake = false;
            boolean isLadder = false;
            if(snakeAndLadder.containsKey(nextPosition)){
                if(snakeAndLadder.get(nextPosition) < nextPosition){
                    isSnake = true;
                }else{
                    isLadder = true;
                }
            }
            if(isSnake){
                currentPlayer.setPosition(nextPosition);
                sb.append(" and bitten by snake at ").append(nextPosition);
                nextPosition = snakeAndLadder.get(nextPosition);
            }
            if(isLadder){
                currentPlayer.setPosition(nextPosition);
                sb.append(" and climbed the ladder at ").append(nextPosition);
                nextPosition = snakeAndLadder.get(nextPosition);
            }
            sb.append(" and moved from ").append(currentPlayer.getPosition());
            sb.append(" to ").append(nextPosition);
            currentPlayer.setPosition(nextPosition);
            System.out.println(sb.toString());
        }while(!isCurrentPlayerWon(players.get(i).getPosition()));
        return;
    }

    public boolean isCurrentPlayerWon(int position){
        return position == 100;
    }
    public boolean isNextPositionLessThan100(int position){
        return position <= 100;
    }
    public void setPlayersPosition(){
        for(Player player : players){
            player.setPosition(1);
        }
    }
}
