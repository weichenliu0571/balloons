import java.io.*;
import java.util.*;

public class Woo {

  private static InputStreamReader isr = new InputStreamReader( System.in );
  private static BufferedReader in = new BufferedReader( isr );

  public void newGame() {
    System.out.println("Welcome to a new game of Tic Tac Toe!!");
    System.out.println("Player X will use Xs as their marker, while Player O will use Os as their marker.");
    System.out.println("On each turn, enter the NUMBER of the cell you wish to play your piece in!");
  }

  public static void main(String[] args) {
    TicTacToe balloons = new TicTacToe();
    System.out.println("Welcome to a new game of Tic Tac Toe!!");
    System.out.println("Player X will use Xs as their marker, while Player O will use Os as their marker.");
    System.out.println("On each turn, enter the NUMBER of the cell you wish to play your piece in!");

    while (!balloons.gameWon() ) {
      System.out.println( balloons );
      try {
        balloons.playTurn( Integer.parseInt( in.readLine() ) );
      }
      catch ( IOException e ) { }
    }
    System.out.println( balloons.winner() + " won!!");
    System.out.println( balloons );
  }

}
