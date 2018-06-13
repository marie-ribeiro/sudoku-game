/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku2;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author marie
 */
public class Sudoku2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size = 3;
        board board = new board(size); //can set grid size here; enter int x, to be x*x grid. default =3
        problem newprob = new problem(size);
        HashMap<Integer, Integer> problem=newprob.generateProblem();
        board.initialiseBoard(problem);
        
    }
    
}
