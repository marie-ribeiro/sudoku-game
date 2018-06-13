/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author marie
 */
public class board extends JPanel implements ActionListener{
    
    public static final Font FONT_GRID = new Font("SERIF",Font.PLAIN, 40);
    public static final Font FONT_MENU = new Font("SERIF",Font.PLAIN, 18);
    public static final int CELL_SIZE = 60;
    int CANVAS_WIDTH;
    int CANVAS_HEIGHT;
    private int subgrid_no; // x*x board
    private int noHiddenSqs = 30;//maybe have in option menu the ability to choose difficulty
    ////private double gridHeight;
    private double gridWidth;
    public board(int i){ //i*i grid
        subgrid_no = i;
        this.CANVAS_WIDTH = CELL_SIZE * subgrid_no*3;
        this. CANVAS_HEIGHT= CELL_SIZE * subgrid_no*3;
        
    }
    public board(){
        this(3);
        this.CANVAS_WIDTH = CELL_SIZE * subgrid_no*3;
        this. CANVAS_HEIGHT= CELL_SIZE * subgrid_no*3;

    }
  
    public void initialiseBoard(HashMap<Integer, Integer> problem){
         
        int SUBGRID_LENGTH = 3;
        int GRID_LENGTH = subgrid_no * SUBGRID_LENGTH; //board size
        
        JFrame frame = new JFrame("New Game!");
        frame.setLayout(new GridLayout(GRID_LENGTH, GRID_LENGTH));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));//
        
        System.out.println(GRID_LENGTH);
        
        NumberFormat format = NumberFormat.getInstance();//singleton class creation; only one class to be created and referenced
        NumberFormatter formatter = new NumberFormatter(format);
        
        //draw grid
        int x=0; int rowCount=0; int borderCount=0; int fixBorder=0;
        for(int i=0; i<GRID_LENGTH; i++){
            rowCount ++;
            borderCount = 0;
            for(int j=0; j<GRID_LENGTH ; j++){
                square sq = new square(formatter, j, 0,x);
                sq.setText(""+problem.get(x));
                x++; 
                borderCount++;
                sq.setFont(FONT_GRID);
                sq.setBackground(Color.white);
                sq.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                sq.setHorizontalAlignment(JTextField.CENTER);
                if(borderCount % 3 == 0 && borderCount!=GRID_LENGTH){
                    sq.setBorder(BorderFactory.createMatteBorder(1,1,1,3, Color.BLACK));
                    fixBorder++;
                }
                if(rowCount % 3 == 0){
                    sq.setBorder(BorderFactory.createMatteBorder(1,1,3,1, Color.BLACK));
                    fixBorder++;
                }
                if(fixBorder == 2){
                    sq.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.BLACK));
                }
                
                fixBorder = 0;
                frame.add(sq);
            }
        
        }
       
        addMenu(frame);
        frame.pack();
        frame.setVisible(true);
        
       
    }
    
    public void addMenu(JFrame frame){
         //adding menu bar
        MenuBar menuBar = new MenuBar();
        //first option and subitems
        Menu newGameOpt = new Menu("New Game");
        MenuItem lvl2x2 = new MenuItem("2x2");
        MenuItem lvl3x3 = new MenuItem("3x3");
        MenuItem lvl6x6 = new MenuItem("6x6");
        MenuItem lvl9x9 = new MenuItem("9x9");
        //adding menu items to main option
        newGameOpt.add(lvl2x2);
        newGameOpt.add(lvl3x3);
        newGameOpt.add(lvl6x6);
        newGameOpt.add(lvl9x9);
        //second option and subitems
        Menu solveOpt = new Menu("Solve!");
        //thrid option
        Menu clearAllOpt = new Menu("Clear All");
        //possible extensions to save game and load old game and have a timer 
        menuBar.add(newGameOpt);
        menuBar.add(solveOpt);
        menuBar.add(clearAllOpt);
        //add listener to level options, as well as 'solve' and 'clear all' option
        lvl2x2.addActionListener(this);
        lvl3x3.addActionListener(this);
        lvl6x6.addActionListener(this);
        lvl9x9.addActionListener(this);
        solveOpt.addActionListener(this);
        clearAllOpt.addActionListener(this);
        
        menuBar.setFont(FONT_MENU);
        frame.setMenuBar(menuBar);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("2x2")){
            System.out.println("2*2");
        }
    }
    
    
}


