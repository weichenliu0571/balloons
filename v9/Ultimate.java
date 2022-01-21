/*
Balloons - Josiah Moltz, Weichen Liu, Sophia Eiden.
APCS pd 6
2022 - 1 - 20
Final Project - (Tic Tac Toe)^2
*/
public class Ultimate {
  private int[][] board = new int[9][9];
  private int[] wonBoards = new int[9];

  private final String O = "\u001B[32mO\u001B[0m";  // O
  private final String X = "\u001B[36mX\u001B[0m";  // X

  private int nextBoard = -1;
  private int marker = -1;  // -1 is an X, -2 is an O

  public Ultimate() { // sets all values in the board to their corresponding #
    for (int i = 0; i < 9; i++) {
      for (int j =0; j < 9; j++){
        board[i][j] = j;
      }
      wonBoards[i] = 0;
    }
  }

  public String translate(int i){ // turns a numeric marker into and X or O
    if (i == -2){
      return " "+ O;
    }
    else if (i == -1){
      return " "+ X;
    }
    else{
      return " "+ i;
    }

  }

  public String translate(int i, int j){ // chooses what to display and what not to display, e.g. if a board has been won, print a large X.
    if ( wonBoards[i] == -1) {
      if (j == 0 || j == 3 || j == 5 || j == 6) {
        return "  ";
      }
      else if (j == 1 || j == 8) {
        return "\u001B[36m\\ \u001B[0m";
      }
      else if (j == 2 || j == 7) {
        return "\u001B[36m/ \u001B[0m";
      }
      else {
        return " " + X;
      }
    }
    else if ( wonBoards[i] == -2) {
      if (j == 0 || j == 4 || j == 6) {
        return "  ";
      }
      else if (j == 1 || j == 7) {
        return "\u001B[32m--\u001B[0m";
      }
      else if (j == 2 || j == 8) {
        return "\u001B[32m- \u001B[0m";
      }
      else{
        return "\u001B[32m |\u001B[0m";
      }

    }
    else if (board[i][j] == j && i !=nextBoard){
      return "  ";
    }
    else{
        return translate(board[i][j]);
    }
  }

  public String toString() { // brute force prints the board very prettily.
    return (
      translate(0,0) + translate(0,1) + translate(0,2) + " |" +
        translate(1,0) + translate(1,1) + translate(1,2) + " |" +
        translate(2,0) + translate(2,1) + translate(2,2) + "\n" +
      translate(0,3) + translate(0,4) + translate(0,5) + " |" +
        translate(1,3) + translate(1,4) + translate(1,5) + " |" +
        translate(2,3) + translate(2,4) + translate(2,5) + "\n" +
      translate(0,6) + translate(0,7) + translate(0,8) + " |" +
        translate(1,6) + translate(1,7) + translate(1,8) + " |" +
        translate(2,6) + translate(2,7) + translate(2,8) + "\n" +
        "-------+-------+-------\n" +
      translate(3,0) + translate(3,1) + translate(3,2) + " |" +
        translate(4,0) + translate(4,1) + translate(4,2) + " |" +
        translate(5,0) + translate(5,1) + translate(5,2) + "\n" +
      translate(3,3) + translate(3,4) + translate(3,5) + " |" +
        translate(4,3) + translate(4,4) + translate(4,5) + " |" +
        translate(5,3) + translate(5,4) + translate(5,5) + "\n" +
      translate(3,6) + translate(3,7) + translate(3,8) + " |" +
        translate(4,6) + translate(4,7) + translate(4,8) + " |" +
        translate(5,6) + translate(5,7) + translate(5,8) + "\n" +
        "-------+-------+-------\n" +
      translate(6,0) + translate(6,1) + translate(6,2) + " |" +
        translate(7,0) + translate(7,1) + translate(7,2) + " |" +
        translate(8,0) + translate(8,1) + translate(8,2) + "\n" +
      translate(6,3) + translate(6,4) + translate(6,5) + " |" +
        translate(7,3) + translate(7,4) + translate(7,5) + " |" +
        translate(8,3) + translate(8,4) + translate(8,5) + "\n" +
      translate(6,6) + translate(6,7) + translate(6,8) + " |" +
        translate(7,6) + translate(7,7) + translate(7,8) + " |" +
        translate(8,6) + translate(8,7) + translate(8,8) + "\n\n"
      );
  }

  public boolean playTurn(int i){
      if ( board[nextBoard][i] != i ) {// if location is already filled
        System.out.println("Please pick non occupied cell");
      }
      else {
        board[nextBoard][i] = marker; // place marker
        localWinCheck(nextBoard);// winCheck
        nextBoard = i; // set nextBoard
        if (marker == -2) {// set marker again
          marker = -1;//X
        }
        else {
          marker = -2;//O
        }
        if ( wonBoards[nextBoard] != 0 || isFilledLocal(nextBoard)) { //tell driver to ask for a new board input
          return false;
        }
    }
    // return all gucci
    return true;
  }

  public void setNextBoard( int i ) {// to be used at start of game
    nextBoard = i;
  }

  public String getMarker() {// returns marker
    return translate(marker);
  }

  public void localWinCheck(int i) {
    // sets wonBoards[i] to who won local board i, and 0 if no one won
    if (board[i][0] == board[i][1] && board[i][1] == board[i][2]){
      wonBoards[i] = board[i][0];
    }
    else if (board[i][3] == board[i][4] && board[i][4] == board[i][5]){
      wonBoards[i]= board[i][3];
    }
    else if (board[i][6] == board[i][7] && board[i][7] == board[i][8]){
      wonBoards[i] = board[i][6];
    }
    else if (board[i][0] == board[i][3] && board[i][3] == board[i][6]) {
      wonBoards[i]= board[i][0];
    }
    else if (board[i][1] == board[i][4] && board[i][4] == board[i][7]) {
      wonBoards[i]= board[i][1];
    }
    else if (board[i][2] == board[i][5] && board[i][5] == board[i][8]) {
      wonBoards[i]= board[i][2];
    }
    else if (board[i][0] == board[i][4] && board[i][4] == board[i][8]) {
      wonBoards[i]= board[i][0];
    }
    else if (board[i][2] == board[i][4] && board[i][4] == board[i][6]) {
      wonBoards[i] = board[i][2];
    }
    else {
      wonBoards[i] = 0;
    }
  }

  public boolean gameWon(){
    // return boolean of whether game is won
    return (
      (wonBoards[0] == wonBoards[1] && wonBoards[1] == wonBoards[2] && wonBoards[0] != 0) ||
      (wonBoards[3] == wonBoards[4] && wonBoards[4] == wonBoards[5] && wonBoards[3] != 0) ||
      (wonBoards[6] == wonBoards[7] && wonBoards[7] == wonBoards[8] && wonBoards[6] != 0) ||
      (wonBoards[0] == wonBoards[3] && wonBoards[3] == wonBoards[6] && wonBoards[0] != 0) ||
      (wonBoards[1] == wonBoards[4] && wonBoards[4] == wonBoards[7] && wonBoards[1] != 0) ||
      (wonBoards[2] == wonBoards[5] && wonBoards[5] == wonBoards[8] && wonBoards[2] != 0) ||
      (wonBoards[0] == wonBoards[4] && wonBoards[4] == wonBoards[8] && wonBoards[0] != 0) ||
      (wonBoards[2] == wonBoards[4] && wonBoards[4] == wonBoards[6] && wonBoards[2] != 0)
    );
  }

  public boolean isFilledLocal(int i ){// check for local boards filled-ness
    for (int j = 0; j < 9; j++) {
      if (board[i][j] == j) {
        return false;
      }
    }
    return true;
  }

  public boolean isFilled() {// check for main board filled-ness
    for (int i = 0; i < 9; i++) {
      if (wonBoards[i] == 0){
        return false;
      }
      if (!isFilledLocal(i)){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) { // tester method
    Ultimate balloons = new Ultimate();
    for (int i = 0; i < 9; i++) {
      balloons.board[i][0] = -1;
      balloons.board[i][1] = -2;
      balloons.board[i][2] = -1;
      balloons.board[i][3] = -2;
      balloons.board[i][4] = -1;
      balloons.board[i][5] = -2;
      balloons.board[i][6] = -1;
      balloons.board[i][7] = -2;
    }
    System.out.println(balloons);
    System.out.println(balloons.isFilled());
  }

}
