package trivia;

public class Player {
    final String name;
    int place;
    int purse;
    boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.place = 0;
        this.purse = 0;
        this.inPenaltyBox = false;
    }

    public String getName() {
        return name;
    }

    public boolean getInPenaltyBox() {
        return inPenaltyBox;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setPurse(int gold) {
        this.purse = gold;
    }

    public int getPurse() {
        return purse;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }
}
