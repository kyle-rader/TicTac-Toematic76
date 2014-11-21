/**
 * Created by raderk on 11/17/2014.
 */

import java.util.*;
import java.io.*;

public class Game {

    public char board[][];
    public int paths[];
    public char computer;
    public char turn;
    int depth = 0;

    public Game() {
        board = new char[][] {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'k'}};
        paths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, };
        computer = 'X';
        turn = 'O';
        depth = 0;
    }

    public Game(Game oldGame) {
        board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = oldGame.board[i][j];
            }
        }
        paths = new int[8];
        for(int i = 0; i < 8; i++)
            this.paths[i] = oldGame.paths[i];
        this.computer = oldGame.computer;
        this.turn = oldGame.turn;
        this.depth = oldGame.depth;
    }

    public void getSettings() {
        System.out.println("Who is the computer?");
        String line;
        try {
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            if (line.length() == 0)
                throw new NumberFormatException();
            char c = line.charAt(0);
            if (c == 'x' || c == 'X' || c == 'o' || c == 'O')
                this.computer = c == 'x' || c == 'X' ? 'X' : 'O';
            else
                throw new NumberFormatException();

            System.out.format("Great! The computer is %c.", this.computer);

        } catch (NumberFormatException ex) {
            System.out.println("No that's no what I asked for!\nThe computer will be X on account of your incompetence.");
            this.computer = 'X';
        }
    }
}
