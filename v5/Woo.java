import java.io.*;
import java.util.*;

public class Woo {

  private static InputStreamReader isr = new InputStreamReader( System.in );
  private static BufferedReader in = new BufferedReader( isr );

  public static void main(String[] args) {
    int nextPlay = 0;
    Ultimate balloons = new Ultimate();
    System.out.println("Welcome to a new game of Tic Tac Toe!!");
    System.out.println("Player X will use Xs as their marker, while Player O will use Os as their marker.");
    System.out.println("On each turn, enter the NUMBER of the cell you wish to play your piece in!");

    System.out.println(balloons);

    System.out.println("Player " + balloons.getMarker() + " pick a local board to play in!");
    try {
      balloons.setNextBoard( Integer.parseInt( in.readLine() ) );
    }
    catch ( IOException e ) { }

    while ( !balloons.gameWon() ) {
      System.out.println(balloons);

      System.out.println("Player " + balloons.getMarker() + " pick a square to play in!");
      try {
        nextPlay = Integer.parseInt( in.readLine() );
      }
      catch ( IOException e ) { }

      if ( !balloons.playTurn( nextPlay ) ) {
        System.out.println("Player + " + balloons.getMarker() + ", this board is already won.");
        System.out.println("Pick a new local board to play in!");
        try {
          balloons.setNextBoard( Integer.parseInt( in.readLine() ) );
        }
        catch ( IOException e ) { }

        System.out.println("Player " + balloons.getMarker() + " pick a square to play in!");
        try {
          nextPlay = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }
      }
    }
    System.out.println("Sorry player " + balloons.getMarker() + " you lost!");
  }

}
