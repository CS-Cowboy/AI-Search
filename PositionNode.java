package AIMazeRunner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;

/**
 *
 * @author Jakeeee
 */
public class PositionNode {

    public int x, y, fCost;
    public static Maze m;
    public PositionNode parent;
    public int euclidDist, manDist;
    PositionComp comp;

    public PositionNode(int x1, int y1, Maze m) {
        x = x1;
        y = y1;
        PositionNode.m = m;

        comp = new PositionComp();
    }

    public PositionNode(int x1, int y1) {
        x = x1;
        y = y1;
    }

    public PositionNode(int x1, int y1, PositionNode parent) {
        x = x1;
        y = y1;
        this.parent = parent;
        euclidDist = euclideanDistance(this);
        manDist = manhattanDistance(this);
        fCost = manDist + euclidDist;
    }

    public LinkedList<PositionNode> neighborList(PositionNode n) {
        LinkedList<PositionNode> list = new LinkedList<>();
        char t = m.map[n.x - 1][n.y];
        if (t == ' ' || t == '*') {
            list.add(new PositionNode(n.x - 1, n.y, n)); //Left neighbor
        }
        t = m.map[n.x + 1][n.y];
        if (t == ' ' || t == '*') {
            list.add(new PositionNode(n.x + 1, n.y, n)); //Right
        }
        t = m.map[n.x][n.y - 1];
        if (t == ' ' || t == '*') {
            list.add(new PositionNode(n.x, n.y - 1, n)); //Up
        }
        t = m.map[n.x][n.y + 1];
        if (t == ' ' || t == '*') {
            list.add(new PositionNode(n.x, n.y + 1, n)); //Down
        }
        return list;
    }

    public int euclideanDistance(PositionNode n) {
        return (int) Math.sqrt(Math.pow(n.x - m.goal.x, 2f) + Math.pow(n.y - m.goal.y, 2f));
    }

    public int manhattanDistance(PositionNode n) {
        return Math.abs(n.x - parent.x) + Math.abs(n.y - parent.y);
    }

}
