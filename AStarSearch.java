/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AIMazeRunner;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Jacob Ziehli
 */
public class AStarSearch {
    
    public  PriorityQueue<PositionNode> open;
    public  LinkedList<PositionNode> closed;
    private Maze maze;
    
    private int rebuildPath(PositionNode k)
    {
        int c = 0;
        while(k.parent != null)
        {
            maze.map[k.parent.x][k.parent.y] = 'O';
            k = k.parent;
            c++;
        }
        return c;
    }
    
    public void search(Maze m, PositionNode first)
    {
        PositionComp comp;
        int nodesExpanded = 0;
        this.maze = m;
        comp = new PositionComp();
        open = new PriorityQueue<PositionNode>(comp);
        closed = new LinkedList<PositionNode>();
        
        open.add(first);
        first.parent = null;
        while(!open.isEmpty())
        {
            m.present = open.peek();
            if(m.map[m.present.x][m.present.y] == '*')
            {
                int c = rebuildPath(m.present);
                maze.printMaze();
                System.out.println("Done. Nodes expanded=\t" + nodesExpanded + "Optimal path=" + c);
                return;
            }
            open.remove(m.present);
            closed.add(m.present);
            nodesExpanded++;
           LinkedList<PositionNode> temp = m.present.neighborList(m.present);
           
           for(int i = 0; i < temp.size(); i++)
           {
               PositionNode n = temp.get(i);
               if(closed.contains(n))
               {
                   continue;
               } else
               {
                   if(!open.contains(n))
                   {
                       open.add(n);
                       m.map[m.present.x][m.present.y] = 'x';
                   } else if (m.present.euclidDist >= n.euclidDist)
                   {
                       continue;
                   }
               }    
           }
           m.printMaze();
           
        }
        
    }
    
}
