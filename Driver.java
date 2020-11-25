/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AIMazeRunner;

/**
 *
 * @author Jacob Ziehli
 */
public class Driver {
    public static void main(String[] args)
    {
        Maze theMaze;
        if(args.length >= 1)
        {
            theMaze = new AIMazeRunner.Maze(args[0]);
        }
        else
        {
            System.out.println("Usage: <filename.txt>");
            return;
        }
        AStarSearch aStar = new AStarSearch();
        aStar.search(theMaze, theMaze.start);
    }
}
