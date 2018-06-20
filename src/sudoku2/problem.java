/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author marie
 */
public class problem {
    
    private int fitness;
    private int [] evaluation;
    private int size;
    private int [][] cells; 
    public problem(int size){
        this.size = size;
        cells = new int[size*3][size*3];
    }
    
    public int[][] generateProblem(){//specify size of problem set eg 3 for 3*3 grid
        //generate cells that meet the constraints of a sudoku game
        //done by region/grid
        //HashMap<Integer, Integer> cells = new HashMap<Integer, Integer>();
        
        Integer vals[] = new Integer[]{1,2,3,4,5,6,7,8,9};
        int k=0;
        //gen random solutions
        /*for(int i=0; i<size*size; i++){
            Collections.shuffle(Arrays.asList(vals));
            System.out.println("\n");
            for(int j=0; j< vals.length; j++){
                cells.put(k, vals[j]);
                System.out.print(""+vals[j]);
                k++;
            }
        }*/
        
        int x = 0;
        for(int i=0; i<size*3; i++){//rows
            Collections.shuffle(Arrays.asList(vals));
            System.out.println("\n");
            for(int j=0; j<size*3; j++){//col
                cells[i][j] = vals[x];
                System.out.print(""+vals[x]);
                x=(x+1)%vals.length; 
                
            }
        }
        //call fixer functions; and then pass the complete solution as cells
        System.out.println("here");
        fixRegion();
        System.out.println("here2");
        return cells;
    }
    
    public void fixRegion(){
        //ArrayList<Integer> numberFound = new ArrayList<>();
        //ArrayList<Integer> numberUnused = new ArrayList<>();
        
        int k=0; int l=3;
        int m=0; int n=3;
        int x=0,y=0, count =0;
        
        while(count < size*size){//counting by region
            System.out.println("count"+count);
            ArrayList<Integer> numberFound = new ArrayList<>();
            ArrayList<Integer> numberUnused = new ArrayList<>();
            for(int i=1; i< 10; i++){
                numberUnused.add(i);
            }

            System.out.println("x,y"+x+y);
            for(x=k; x<l; x++){
                for(y=m; y<n ; y++){
                    Integer temp = cells[x][y];
                    if(numberUnused.contains(temp) ){
                        numberUnused.remove(temp);
                    }
                }
            }
            //replacing duplicate numbers with numbers from numberUnused
            for(x=k; x<l; x++){
                for(y=m; y<n ; y++){
                    Integer temp = cells[x][y];
                    if(numberFound.contains(temp) ){ //duplicate located
                        cells[x][y] = numberUnused.remove(0);
                    }else{
                        //add number to numberFound
                        numberFound.add(temp);
                    }
                }
            }
                //k=l; l=l+3; n= n+3;
                count++;
                m=n; n = n+3;
                
                if(count>0 && count%size == 0){//new row
                    k=k+3;l=l+3;
                    m=0; n=3;
                }
            
                
        }
        
        /*
        for(int i=1; i< 10; i++){
            numberUnused.add(i);
        }
        
        //numberUnused should have only numbers not appearing in the region
        Integer temp;
        for(int i=0; i< 3; i++){
            for(int j=0; j< 3; j++){
                temp = cells[i][j];
                if(numberUnused.contains(temp) ){
                    numberUnused.remove(temp);
                }
            }
        }
        //replacing duplicate numbers with numbers from numberUnused
        for(int i=0; i< 3; i++){
            for(int j=0; j< 3; j++){
                temp = cells[i][j];
                if(numberFound.contains(temp) ){ //duplicate located
                    cells[i][j] = numberUnused.get(0);
                    numberUnused.remove(0);
                }else{
                    //add number to numberFound
                    numberFound.add(temp);
                }
            }
        }*/
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
