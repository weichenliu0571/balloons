/*
Balloons - Josiah Moltz, Weichen Liu, Sophia Eiden.
APCS pd 6
2022 - 1 - 20
Final Project - (Tic Tac Toe)^2
*/
import java.io.*;
import java.util.*;

public class Woo {

  private static InputStreamReader isr = new InputStreamReader( System.in );
  private static BufferedReader in = new BufferedReader( isr );

  public static void main(String[] args) {
    int nextPlay = 0;
    Ultimate balloons = new Ultimate();
    System.out.println("Welcome to a new game of Ultimate Tic Tac Toe!!");
    System.out.println("Player X will use Xs as their marker, while Player O will use Os as their marker.");
    System.out.println("The board is subdivided into 9 local boards as shown");
    System.out.println("       |       |");
    System.out.println("   0   |   1   |   2");
    System.out.println("       |       |");
    System.out.println("-------+-------+-------");
    System.out.println("       |       |");
    System.out.println("   3   |   4   |   5");
    System.out.println("       |       |");
    System.out.println("-------+-------+-------");
    System.out.println("       |       |");
    System.out.println("   6   |   7   |   8");
    System.out.println("       |       |");
    System.out.println("Each board is subdivided into 9 squares as shown");
    System.out.println(" 0 1 2 | 0 1 2 | 0 1 2 ");
    System.out.println(" 3 4 5 | 3 4 5 | 3 4 5 ");
    System.out.println(" 6 7 8 | 6 7 8 | 6 7 8 ");
    System.out.println("-------+-------+-------");
    System.out.println(" 0 1 2 | 0 1 2 | 0 1 2 ");
    System.out.println(" 3 4 5 | 3 4 5 | 3 4 5 ");
    System.out.println(" 6 7 8 | 6 7 8 | 6 7 8 ");
    System.out.println("-------+-------+-------");
    System.out.println(" 0 1 2 | 0 1 2 | 0 1 2 ");
    System.out.println(" 3 4 5 | 3 4 5 | 3 4 5 ");
    System.out.println(" 6 7 8 | 6 7 8 | 6 7 8 ");
    System.out.println("If a player picks a certain square numbered x, the next player must play on local board x.");
    System.out.println("A local board is won if a player has 3 of their symbol along a row, column, or diagonal in that square.");
    System.out.println("If you are forced to play in a square that is already won, you may pick a new square to play in.");
    System.out.println("The game is won when 3 local boards along a row, column, or diagonal are won by the same person.\n");
    System.out.println("Player" + balloons.getMarker() + " pick a local board to play in!");

    try {
      balloons.setNextBoard( Integer.parseInt( in.readLine() ) );
    }
    catch ( IOException e ) { }

    while ( !balloons.gameWon() && !balloons.isFilled() ) {
      System.out.println(balloons);

      System.out.println("Player" + balloons.getMarker() + " pick a square to play in!");
      try {
        nextPlay = Integer.parseInt( in.readLine() );
      }
      catch ( IOException e ) { }


      if ( !balloons.playTurn( nextPlay ) ) {
        System.out.println(balloons);
        System.out.println("Player" + balloons.getMarker() + ", this board is no longer in play.");
        System.out.println("Pick a new local board to play in!");
        try {
          balloons.setNextBoard( Integer.parseInt( in.readLine() ) );
        }
        catch ( IOException e ) { }

      }
    }
    if (balloons.isFilled()) {
      System.out.println("Sorry, cat got that game!");
    }
    else {
      System.out.println("Sorry player" + balloons.getMarker() + ", you lost!");

    }
  }

}
