/*
Balloons - Josiah Moltz, Weichen Liu, Sophia Eiden.
APCS pd 6
2022 - 1 - 20
Final Project - (Tic Tac Toe)^2

Coded for proof of concept
*/
public class TicTacToe {
  private int[] board = new int[9]; // Board where gameplay takes place
  private int marker = -1;  // -1 is an X, -2 is an O

  public final String ANSI_RESET = "\u001B[0m";
  public final String ANSI_GREEN = "\u001B[32m";
  public final String ANSI_CYAN = "\u001B[36m";

  /*=============================================
    TicTacToe() -- constructor
    pre:
    post: board is initialized where board[i]=i
    =============================================*/
  public TicTacToe(){
    // Populate board
    for (int i = 0; i < 9; i++){
      board[i] = i;
    }
  }

  /*=============================================
    String translate() -- Determines whether square of board has a marker in it
    pre:  board is initialized
    post: returns "O", "X", or i
    =============================================*/
  public String translate(int i){
    if (i == -2){
      return ANSI_GREEN + "O" + ANSI_RESET;
    }
    else if (i == -1){
      return ANSI_CYAN + "X" + ANSI_RESET;
    }
    else{
      return i +"";
    }
  }

  /*=============================================
    String toString() -- displays board in a human friendly fashion
    pre: board is initialized
    post: returns string of translated board
    =============================================*/
  public String toString(){
    return " " + translate(board[0]) + " | " + translate(board[1]) + " | " + translate(board[2]) + "\n" +
           "---+---+---\n" +
           " " + translate(board[3]) + " | " + translate(board[4]) + " | " + translate(board[5]) + "\n" +
           "---+---+---\n" +
           " " + translate(board[6]) + " | " + translate(board[7]) + " | " + translate(board[8]);

  }

  /*=============================================
    void PlayTurn() --
    pre:
    post:
    =============================================*/
  public void playTurn(int i, int newMarker){
    if ( board[i] != i ) {
      System.out.println("Please pick non occupied cell");
    }
    else {
      board[i] = newMarker;
      if (newMarker == -2) {
        marker = -1;}
      else {marker = -2;}
    }
  }

  /*=============================================
    boolean winCheck() -- determins whether the game is won or not
    pre: board is initialized
    post: returns true if game won, and false otherwise
    =============================================*/
  public int winner() {
    if ((board[0] == board[1] && board[1] == board[2])) {
      return board[0];
    }
    else if ((board[3] == board[4] && board[4] == board[5])) {
      return board[3];
    }
    else if ((board[6] == board[7] && board[7] == board[8])) {
      return board[6];
    }
    else if ((board[0] == board[3] && board[3] == board[6])) {
      return board[0];
    }
    else if ((board[1] == board[4] && board[4] == board[7])) {
      return board[1];
    }
    else if ((board[2] == board[5] && board[5] == board[8])) {
      return board[2];
    }
    else if (board[0] == board[4] && board[4] == board[8]) {
      return board[0];
    }
    else if (board[2] == board[4] && board[4] == board[6]) {
          return board[2];
    }
    else {
      return 0; // no winner
    }
  }

  public String row(int i) {
    if (winner() == -1) {
      if (i == 0) {
        return "  \\ / ";
      }
      else if (i == 1) {
        return "   X  ";
      }
      else {
        return "  / \\ ";
      }
    }
    else if (winner() == -2) {
      if (i == 0) {
        return "------";
      }
      else if (i == 1) {
        return "|    |";
      }
      else {
        return "------";
      }
    }
    else {
      return " " + translate(board[3*i]) + " " + translate(board[3*i + 1]) + " " + translate(board[3*i + 2]);
    }
  }
}
