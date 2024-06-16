package org.example;

public class Player {
    private final int id;
    private String name;
    private int currentPosition;
    private static int uuid = 1;

    Player(String name, int currentPosition){
        this.name = name;
        this.currentPosition = currentPosition;
        this.id = generateUniqueId();
    }

    private int generateUniqueId(){
        return uuid++;
    }

    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return currentPosition;
    }

    public void setPosition(int position) {
        this.currentPosition = position;
    }
}
