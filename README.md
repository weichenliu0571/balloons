# balloons

## Sophia Eiden, Josiah Moltz, Weichen Liu

## How to Launch (type the stuff in quotations)
* Go to Terminal
* type "git clone git@github.com:weichenliu0571/balloons.git"
* type "javac *.java"
* type "java Woo.java"
* further instruction will be given in terminal

## Concise description
Player X will use Xs as their marker, while Player O will use Os as their marker.\
The board is subdivided into 9 local boards as shown
```
       |       |
   0   |   1   |   2
       |       |
-------+-------+-------
       |       |
   3   |   4   |   5
       |       |
-------+-------+-------
       |       |
   6   |   7   |   8
       |       |
```
Each board is subdivided into 9 squares as shown
```
 0 1 2 | 0 1 2 | 0 1 2
 3 4 5 | 3 4 5 | 3 4 5
 6 7 8 | 6 7 8 | 6 7 8
-------+-------+-------
 0 1 2 | 0 1 2 | 0 1 2
 3 4 5 | 3 4 5 | 3 4 5
 6 7 8 | 6 7 8 | 6 7 8
-------+-------+-------
 0 1 2 | 0 1 2 | 0 1 2
 3 4 5 | 3 4 5 | 3 4 5
 6 7 8 | 6 7 8 | 6 7 8
```
If a player picks a certain square numbered x, the next player must play on local board x.\
A local board is won if a player has 3 of their symbol along a row, column, or diagonal in that square.\
If you are forced to play in a square that is already won, you may pick a new square.\
The game is won when 3 local boards along a row, column, or diagonal are won by the same person.\
