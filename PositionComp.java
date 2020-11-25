/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AIMazeRunner;

import java.util.Comparator;

/**
 *
 * @author Jacob Ziehli
 */
public class PositionComp implements Comparator<PositionNode> {
    
    @Override
    public int compare(PositionNode o1, PositionNode o2) {
        
        if(o1.fCost < o2.fCost)
        {
            return -1;
        }else if (o1.fCost == o2.fCost)
        {
            return 0;
        }
        return +1;
    }
    
}
