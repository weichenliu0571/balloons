public class Ultimate {
  private int[][] board = new int[9][9];
  private int[] wonBoards = new int[9];

  private final String O = "\u001B[32mO\u001B[0m";  // O
  private final String X = "\u001B[36mX\u001b[0m";  // X

  private int nextBoard = -1;
  private int marker = -1;  // -1 is an X, -2 is an O

  public Ultimate() {
    for (int i = 0; i < 9; i++) {
      for (int j =0; j < 9; j++){
        board[i][j] = j;
      }
      wonBoards[i] = false;
    }
  }

  public String translate(int i){
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

  public String translate(int i, int j){
    if (board[i][j] == j && i !=nextBoard){
      return "  ";
    }
    else{
        return translate(board[i][j]);
    }

  }

  public String toString() {

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

    // is this board still in play ( check wonBoards of next Boards)
    if ( wonBoards[nextBoard] ) {
    // no player picks local nextBoard
      // ask for new input
      // cut round short, play round w/out changing markers
      // return false
      return false; // In driver handle getting new input
    }
    // yes - continue as normal
    else {
        // check if placement is unfilled
        if ( board[nextBoard][i] != i ) {
          System.out.println("Please pick non occupied cell");
        }
        else {
          // place marker
          board[nextBoard][i] = marker; //
          // winCheck
          localWinCheck(nextBoard);
          // set nextBoard
          nextBoard = i;
          // set marker again
          if (marker == -2) {
            marker = -1;
          }
          else {
            marker = -2;
          }
      }
      // return all gucci
      return true;
    }
  }

  public void setNextBoard( int i ) {
    // to be used at start of game
    nextBoard = i;
  }

  public String getMarker() {
    return translate(marker);
  }

  public void localWinCheck(int i) {
    /* 0 - 1 - 2
      3 - 4 - 5
      6 - 7 - 8

      0 - 3 - 6
      1 - 4 - 7
      2 - 5 - 8

      0 - 4 - 8
      2 - 4 - 6

    */
    if (board[i][0] == board[i][1] && board[i][1] == board[i][2]){
      wonBoards[i] = board[i][0];
    }
    else if (board[i][3] == board[i][4] && board[i][4] == board[i][5]){
      wonBoards[i]= board[i][3];
    }
    else if (board[i][6] == board[i][7] && board[i][7] == board[i][8]){

    }
    else if (board[i][0] == board[i][3] && board[i][3] == board[i][6]) {
      wonBoards[i]= board[i][3];
    }
    else if (board[i][1] == board[i][4] && board[i][4] == board[i][7]) {
      wonBoards[i]= board[i][3];
    }
    else if (board[i][2] == board[i][5] && board[i][5] == board[i][8]) {
      wonBoards[i]= board[i][3];
    }
    else if (board[i][0] == board[i][4] && board[i][4] == board[i][8]) {
      wonBoards[i]= board[i][3];
    }
    else if (board[i][2] == board[i][4] && board[i][4] == board[i][6])){

    };
    // set local board equivalent in wonBoards to true
  }

  public boolean gameWon(){
    // return boolean of
    /* 0 - 1 - 2
      3 - 4 - 5
      6 - 7 - 8

      0 - 3 - 6
      1 - 4 - 7
      2 - 5 - 8

      0 - 4 - 8
      2 - 4 - 6

    */
    return (
      (wonBoards[0] && wonBoards[1] && wonBoards[2]) ||
      (wonBoards[3] && wonBoards[4] && wonBoards[5]) ||
      (wonBoards[6] && wonBoards[7] && wonBoards[8]) ||
      (wonBoards[0] && wonBoards[3] && wonBoards[6]) ||
      (wonBoards[1] && wonBoards[4] && wonBoards[7]) ||
      (wonBoards[2] && wonBoards[5] && wonBoards[8]) ||
      (wonBoards[0] && wonBoards[4] && wonBoards[8]) ||
      (wonBoards[2] && wonBoards[4] && wonBoards[6])
    );
  }

  public static void main(String[] args) {
    Ultimate balloons = new Ultimate();
    balloons.setNextBoard(4);
    System.out.println(balloons);
    balloons.playTurn(3);
    System.out.println(balloons);
    balloons.playTurn(4);
    System.out.println(balloons);
    balloons.playTurn(3);
    System.out.println(balloons);
    balloons.playTurn(8);
    System.out.println(balloons);
    balloons.playTurn(7);
    System.out.println(balloons);
  }

}
