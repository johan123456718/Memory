package model;

public class Player {

    private int points, wins, losses;
    private String name;

    public Player(String name) {
        this.name = name;
        points = 0;
        wins = 0;
        losses = 0;
    }

    public String getPlayer() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        this.points++;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        this.wins++;
    }

    public int getLosses() {
        return losses;
    }

    public void addLoss() {
        this.losses++;
    }

    @Override
    public String toString() {
        return "Player [points= " + points + ", wins= " + wins + ", losses= " + losses + "]";
    }
}
