public class Ultimate {
  private int[][] board = new int[9][9];
  private boolean[] wonBoards = new boolean[9];

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
    for
  }

  public String translate(int i){
    if (i == -2){
      return O;
    }
    else if (i == -1){
      return X;
    }
    else{
      return i +"";
    }
  }

  public String toString() {
    String result = "";
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        result += board[i][j]; 
      }
      for (j = 3; j < 6; j++) {
        result += board[i][j]; 
      }
      for (j = 6; j < 9; j++) {
        result += board[i][j]; 
      }
    for (i = 3; i < 6; i++) {
      for (j = 0; j < 3; j++) {
        result += board[i][j]; 
      }
      for (j = 3; j < 6; j++) {
        result += board[i][j]; 
      }
      for (j = 6; j < 9; j++) {
        result += board[i][j]; 
      }
    for (i = 6; i < 9; i++) {
      for (j = 0; j < 3; j++) {
        result += board[i][j]; 
      }
      for (j = 3; j < 6; j++) {
        result += board[i][j]; 
      }
      for (j = 6; j < 9; j++) {
        result += board[i][j]; 
      }
      
    /*
    //BAD BAD BAD NEEDS WORK PLS
    for (int i = 0; i < 9; i += 1) {
      result += board[i/3+0].row(i%3) + " |";
      result += board[i/3+1].row(i%3) + " |";
      result += board[i/3+2].row(i%3);
      if (i == 2 || i == 5) {
        result += "\n-------+-------+-------\n";
      }
      else {
        result += "\n";
      }
    }
    return result;
    //CLEAN UP CLEAN UP EVERYBODY EVERYWHERE
  return (
    translate(board[0][0]) + translate(board[0][1]) + translate(board[0][2]) +
      translate(board[1][0]) + translate(board[1][1]) + translate(board[1][2]) +
      translate(board[2][0]) + translate(board[2][1]) + translate(board[2][2]) + "\n" +
    translate(board[0][3]) + translate(board[0][4]) + translate(board[0][5]) +
      translate(board[1][3]) + translate(board[1][4]) + translate(board[1][5]) +
      translate(board[2][3]) + translate(board[2][4]) + translate(board[2][5]) + "\n" +
    translate(board[0][6]) + translate(board[0][7]) + translate(board[0][8]) +
      translate(board[1][6]) + translate(board[1][7]) + translate(board[7][8]) +
      translate(board[2][6]) + translate(board[2][7]) + translate(board[2][8]) + "\n" +
    translate(board[3][0]) + translate(board[3][1]) + translate(board[3][2]) +
      translate(board[4][0]) + translate(board[4][1]) + translate(board[4][2]) +
      translate(board[5][0]) + translate(board[5][1]) + translate(board[5][2]) + "\n" +
    translate(board[3][3]) + translate(board[3][4]) + translate(board[3][5]) +
      translate(board[4][3]) + translate(board[4][4]) + translate(board[4][5]) +
      translate(board[5][3]) + translate(board[5][4]) + translate(board[5][5]) + "\n" +
    translate(board[3][6]) + translate(board[3][7]) + translate(board[3][8]) +
      translate(board[4][6]) + translate(board[4][7]) + translate(board[4][8]) +
      translate(board[5][6]) + translate(board[5][7]) + translate(board[5][8]) + "\n" +
    translate(board[6][0]) + translate(board[6][1]) + translate(board[6][2]) +
      translate(board[7][0]) + translate(board[7][1]) + translate(board[7][2]) +
      translate(board[8][0]) + translate(board[8][1]) + translate(board[8][2]) + "\n" +
    translate(board[6][3]) + translate(board[6][4]) + translate(board[6][5]) +
      translate(board[7][3]) + translate(board[7][4]) + translate(board[7][5]) +
      translate(board[8][3]) + translate(board[8][4]) + translate(board[8][5]) + "\n" +
    translate(board[6][6]) + translate(board[6][7]) + translate(board[6][8]) +
      translate(board[7][6]) + translate(board[7][7]) + translate(board[7][8]) +
      translate(board[8][6]) + translate(board[8][7]) + translate(board[8][8])
    );
      */
  }

  public boolean playTurn(int i){

    // is this board still in play ( check wonBoards of next Boards)

      // no player picks local nextBoard
        // ask for new input
        // cut round short, play round w/out changing markers
        // return false
      // yes - continue as normal
        // check if placement is unfilled
            /*if ( board[idx] != idx ) {
              System.out.println("Please pick non occupied cell");
            } */
            // place marker
            // set nextBoard
            // set marker again
      // return all gucci
  }

  public void setNextBoard( int i ) {
    // to be used at start of game
    nextBoard = i;
  }

  public void localWinCheck() {
    /* 0 - 1 - 2
      3 - 4 - 5
      6 - 7 - 8

      0 - 3 - 6
      1 - 4 - 7
      2 - 5 - 8

      0 - 4 - 8
      2 - 4 - 6

    */
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
  }

  public static void main(String[] args) {

  }

}
