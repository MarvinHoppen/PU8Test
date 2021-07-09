package trivia;

public class Print {

    public void printAddPlayer(String playerName, int numberOfPlayers) {
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + numberOfPlayers);
    }

    public void printRollHeader(String playerName, int roll) {
        System.out.println(playerName + " is the current player");
        System.out.println("They have rolled a " + roll);
    }

    public void printPlayerExitsBox(String playerName) {
        System.out.println(playerName + " is getting out of the penalty box");
    }

    public void printNewLocation(String playerName, int place) {
        System.out.println(playerName
                + "'s new location is "
                + place);
    }

    public void printCurrentCategory(String currentCategory) {
        System.out.println("The category is " + currentCategory);
    }

    public void printPlayerStays(String playerName) {
        System.out.println(playerName + " is not getting out of the penalty box");
    }

    public void printCorrectlyAnswered(String playerName, int purse) {
        System.out.println("Answer was correct!!!!");
        System.out.println(playerName
                + " now has "
                + purse
                + " Gold Coins.");
    }


    public void printWronglyAnswered(String playerName) {
        System.out.println("Question was incorrectly answered");
        System.out.println(playerName + " was sent to the penalty box");
    }

}
