package AIMazeRunner;

import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Jacob Ziehli
 */
public class Maze {

    public char[][] map = null;

    public PositionNode present, goal, start;

    public Maze(String filename) {
        System.out.println("Reading file: " + filename);

        BufferedReader reader = null;
        try {
            Path p = FileSystems.getDefault().getPath(filename);
            reader = Files.newBufferedReader(p.toAbsolutePath());
        } catch (IOException ioE) {
            System.err.println("On file open:");
            ioE.printStackTrace();
        }

        if (reader != null) {
            readFile(reader);
            printMaze();
        }
    }

    public void printMaze() {
        for (int i = 0; i < map[0].length - 1; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        try
           {
                Thread.sleep(0);
           } catch(InterruptedException ie)
           {
               System.out.println("Interrupted: " + ie.getMessage());
               ie.printStackTrace();
           }
    }

    private void readFile(BufferedReader bRdr) {
        int j = 0, i = 0;

        try {
            String t = bRdr.readLine();
            map = new char[t.length()][t.length()];

            for (i = 0; i < t.length(); i++) {
                for (j = 0; j < t.length(); j++) {
                    map[i][j] = t.charAt(j);
                    if (map[i][j] == 'P') {
                        //We have our starting position
                        start = new PositionNode(i,j, this);
                        present = new PositionNode(i, j);
                    } else if (map[i][j] == '*') {
                        //We have our goal
                        goal = new PositionNode(i, j);
                    }
                }

                t = bRdr.readLine();
                if (t == null) {
                    break;
                }
            }
        } catch (IOException ioE) {
            System.err.println("On file read line #\t" + j + "Column\t#\t" + i);
            ioE.printStackTrace();
        } finally {
            try {
                bRdr.close();
            } catch (IOException ioE) {
                System.err.println("On file close");
                ioE.printStackTrace();
            }
        }

    }
}
