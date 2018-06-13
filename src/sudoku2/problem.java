/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author marie
 */
public class problem {
    
    private int fitness;
    private int [] evaluation;
    private int size;
    
    public problem(int size){
        this.size = size;
    }
    
    public HashMap<Integer, Integer> generateProblem(){//specify size of problem set eg 3 for 3*3 grid
        //generate cells that meet the constraints of a sudoku game
        //done by region/grid
        HashMap<Integer, Integer> cells = new HashMap<Integer, Integer>();
        Integer vals[] = new Integer[]{1,2,3,4,5,6,7,8,9};
        int k=0;
        //gen random solutions
        for(int i=0; i<size*size; i++){
            Collections.shuffle(Arrays.asList(vals));
            System.out.println("\n");
            for(int j=0; j< 9; j++){
                cells.put(k, vals[j]);
                System.out.print(""+vals[j]);
                k++;
            }
        }
        return cells;
    }
    
    public int calculateFitness(){
        //find fitness of problem solution
        //each row in cell, is treated as a grid, if collision present, grid assigned 0
        for(int i=0; i< size*size; i++){
            for(int j=0; j < 9; j++){
                //check for collision in row and column
                
            }
        }
        return fitness;
    }
}
