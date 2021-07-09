package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
  ArrayList<Player> players = new ArrayList();

  LinkedList popQuestions = new LinkedList();
  LinkedList scienceQuestions = new LinkedList();
  LinkedList sportsQuestions = new LinkedList();
  LinkedList rockQuestions = new LinkedList();

  Print print = new Print();

  public static final String POP = "Pop";
  public static final String SCIENCE = "Science";
  public static final String SPORTS = "Sports";
  public static final String ROCK = "Rock";

  int currentPlayer = 0;
  boolean isGettingOutOfPenaltyBox;

  public Game() {
    for (int i = 0; i < 50; i++) {
      popQuestions.addLast("Pop Question " + i);
      scienceQuestions.addLast(("Science Question " + i));
      sportsQuestions.addLast(("Sports Question " + i));
      rockQuestions.addLast(("Rock Question " + i));
    }
  }

  public boolean isPlayable() {
    return (players.size() >= 2);
  }

  public void add(String playerName) {
    players.add(new Player(playerName));
    print.printAddPlayer(playerName, players.size());
  }

  public void roll(int roll) {
    print.printRollHeader(getPlayerName(),roll);

    if (isInPenaltyBox()) {
      if (roll % 2 != 0) {
        isGettingOutOfPenaltyBox = true;
        print.printPlayerExitsBox(getPlayerName());

        updateLocation(roll);
        print.printCurrentCategory(currentCategory());
        askQuestion();
      }
      else {
        print.printPlayerStays(getPlayerName());
        isGettingOutOfPenaltyBox = false;
      }

    }
    else {
      updateLocation(roll);
      print.printCurrentCategory(currentCategory());
      askQuestion();
    }

  }

  private void updateLocation(int roll) {
    setPlace(getPlace() + roll);
    if (getPlace() > 11) {
      setPlace(getPlace() - 12);
    }
    print.printNewLocation(getPlayerName(), getPlace());
  }

  private int getPlace() {
    return players.get(currentPlayer).getPlace();
  }

  private void setPlace(int place) {
    players.get(currentPlayer).setPlace(place);
  }

  private String getPlayerName() {
    return players.get(currentPlayer).getName();
  }

  private void askQuestion() {
    if (currentCategory() == POP) {
      System.out.println(popQuestions.removeFirst());
    }
    if (currentCategory() == SCIENCE) {
      System.out.println(scienceQuestions.removeFirst());
    }
    if (currentCategory() == SPORTS) {
      System.out.println(sportsQuestions.removeFirst());
    }
    if (currentCategory() == ROCK) {
      System.out.println(rockQuestions.removeFirst());
    }
  }


  private String currentCategory() {
    if (getPlace() % 4 == 0) return POP;
    if (getPlace() % 4 == 1) return SCIENCE;
    if (getPlace() % 4 == 2) return SPORTS;
    return ROCK;
  }

  public boolean wasCorrectlyAnswered() {
    if (isInPenaltyBox()) {
      if (isGettingOutOfPenaltyBox) {
        setPurse(getPurse() +1);
        print.printCorrectlyAnswered(getPlayerName(),getPurse());
        boolean winner = didPlayerWin();
        nextPlayer();
        return winner;
      }
      else {
        nextPlayer();
        return true;
      }
    }
    else {
      setPurse(getPurse() +1);
      print.printCorrectlyAnswered(getPlayerName(),getPurse());
      boolean winner = didPlayerWin();
      nextPlayer();
      return winner;
    }
  }

  private void nextPlayer() {
    currentPlayer++;
    if (currentPlayer == players.size()) currentPlayer = 0;
  }

  private int getPurse() {
    return players.get(currentPlayer).getPurse();
  }

  private void setPurse(int purse) {
    players.get(currentPlayer).setPurse(purse);
  }
  private boolean isInPenaltyBox() {
    return players.get(currentPlayer).getInPenaltyBox();
  }

  public boolean wrongAnswer() {
    print.printWronglyAnswered(getPlayerName());

    players.get(currentPlayer).setInPenaltyBox(true);

    nextPlayer();
    return true;
  }


  private boolean didPlayerWin() {
    return !(getPurse() == 6);
  }
}
