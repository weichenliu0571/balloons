public class TicTacToe{
  int[] board = new int[9];
  int marker = -1;

  public TicTacToe(){
    for (int i = 0; i < 9; i++){
      board[i] = i;
    }
  }
  public String translate(int i){
    if (i == -2){
      return "O";
    }
    else if (i == -1){
      return "X";
    }
    else{
      return i +"";
    }
  }

  public String toString(){
    return translate(board[0]) + "|" + translate(board[1]) + "|" + translate(board[2]) + "\n" +
           translate(board[3]) + "|" + translate(board[4]) + "|" + translate(board[5])  + "\n" +
           translate(board[6]) + "|" + translate(board[7]) + "|" + translate(board[8]);


  }
  public void playTurn(int idx){
    board[idx] = marker;
    if (winCheck()){
      System.out.println(translate(marker) + " won! blah blah blah");
      gameOver = true;
    if (marker == -2) {
      marker = -1;}
    else {marker = -2;}

    }
  }

  public boolean winCheck(){
    if ((board[0] == board[1] == board[2]) ||
        (board[3] == board[4] == board[5]) ||
        (board[6] == board[7] == board [8]) ||
        (board[0] == board[3] == board[6] )||
        (board[1] == board[4] == board[7])||
        (board[2] == board[5] == board[8]) ||
        (board[0] == board[4] == board[8]) ||
        (board[2] == board[4] == board[6]))
        {
          return true;
        }
  }
  public static void main(String[] args) {
    TicTacToe tester = new TicTacToe();
    System.out.println(tester);
    tester.playTurn(3);
        System.out.println(tester);

  }
}
