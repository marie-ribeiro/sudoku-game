/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku2;

import javax.swing.JFormattedTextField;

/**
 *
 * @author marie
 */
public class square extends JFormattedTextField{
    private final int row;
    private final int column;
    private final int key;
    private int gridID; //each grid assigned an int by counting horizontally
    private int visible;
    
    public square(AbstractFormatter formatter, int row, int column, int key){
        super(formatter);
        this.row = row;
        this.column = column;
        this.key = key;
    }
       
    public int getKey(){
        return key;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public int getGridID(){
        return gridID;
    }
    public int getVisibility(){
        return visible;
    }
    public void setVisibility(int vis){
        visible = vis;
    }
    public void setGridID(int id){
        gridID = id;
    }
}
