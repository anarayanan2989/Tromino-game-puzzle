/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adithya_2
 */

/* Adithya Narayanan
   L20375088
   Tiling Problem
   Analysis of Algorithms
   COSC 5313_01_1   
*/ 
import java.io.*;
import java.util.Scanner;

public class tromino
{
           int  X_Origin,          //Initial X-cordinate from which the tromino can be moved          
                Y_Origin,          //Initial Y-cordinate from which the tromino can be moved 
                Missing_X_Ltop,	   //X-cordinate for the tile missing at the top of the centre tile from the left
                Missing_Y_Ltop,	   //Y-cordinate for the tile missing at the top of the centre tile from the left
                Missing_X_Rtop,    //X-cordinate for the tile missing at the top of the centre tile from the right
                Missing_Y_Rtop,    //Y-cordinate for the tile missing at the top of the centre tile from the right
                Missing_X_Rbottom, //X-cordinate for the tile missing at the bottom of the centre tile from the right
                Missing_Y_Rbottom, //Y-cordinate for the tile missing at the bottom of the centre tile from the right
                Missing_X_Lbottom, //X-cordinate for the tile missing at the bottom of the centre tile from the left
                Missing_Y_Lbottom; //Y-cordinate for the tile missing at the bottom of the centre tile from the left
		
    // Default  constructor		
    public tromino()
    {
    }
    
    
    public void ftromino (int X_Position, int Y_Position, int X_missPos, int Y_missPos, int boardSize) 
    {
        int subboardSize = boardSize / 2;    /* size of sub-board */
                
		
        if (boardSize == 2) 
		{   
            System.out.println((X_Position + 1)+" "+(Y_Position + 1));
            /* Finding  the orientation according to missing square */
            if (X_Position == X_missPos)  
			{
                if (Y_Position == Y_missPos)  
				{
                    System.out.println("Orientation 0\n");
                } 
				else  
				{
                    System.out.println("Orientation 1\n");
                }
            } 
			else
                if (Y_Position == Y_missPos)
			{
                System.out.println("Orientation 3\n");
            }
			else
			{
                System.out.println("Orientation 2\n");
            }
            return;
        }

        /* Computing the centre co-ordinates  */
        X_Origin = X_Position + subboardSize;
        Y_Origin = Y_Position + subboardSize;

       
        System.out.println(X_Origin+" "+Y_Origin);

        /*  Computing the orientation according to missing square */
        if (X_missPos < X_Origin) 
		{		 
            Missing_X_Rtop = Missing_X_Rbottom = X_Origin;
            Missing_Y_Rtop = Y_Origin;
            Missing_Y_Rbottom = Y_Origin - 1;
			/* Orientation 0 */
            if (Y_missPos < Y_Origin) 
			{			
                System.out.println("Executing Orientation 0.....\n");
                Missing_X_Ltop = X_Origin - 1;
                Missing_Y_Ltop = Y_Origin;
                Missing_X_Lbottom = X_missPos;
                Missing_Y_Lbottom = Y_missPos;
            }
			/* Orientation 1 */			
			else 
			{		 
                System.out.println("Executing Orientation 1.....\n");
                Missing_X_Ltop = X_missPos;
                Missing_Y_Ltop = Y_missPos;
                Missing_X_Lbottom = X_Origin - 1;
                Missing_Y_Lbottom = Y_Origin - 1;
            }
        }
				
		else 
		{
                    Missing_X_Ltop = Missing_X_Lbottom = X_Origin - 1;
                    Missing_Y_Ltop = Y_Origin;
                    Missing_Y_Lbottom = Y_Origin - 1;
			/* Orientation 3*/
                    if (Y_missPos < Y_Origin) 
			{			
                            System.out.println("Executing Orientation 3.....\n");
                            Missing_X_Rtop = X_Origin;
                            Missing_Y_Rtop = Y_Origin;
                            Missing_X_Rbottom = X_missPos;
                            Missing_Y_Rbottom = Y_missPos;
                        } 
			/* Orientation 2*/
		    else 
		    {		
				System.out.println("Executing Orientation 2.....\n");
                                Missing_X_Rtop = X_missPos;
                                Missing_Y_Rtop = Y_missPos;
                                Missing_X_Rbottom = X_Origin;
                                Missing_Y_Rbottom = Y_Origin - 1;
                    }
                }

                /* Calling ftromino recursively for all four sub-boards */
                ftromino(X_Position, Y_Position + subboardSize, Missing_X_Ltop, Missing_Y_Ltop, subboardSize);
                ftromino(X_Position + subboardSize, Y_Position + subboardSize, Missing_X_Rtop, Missing_Y_Rtop, subboardSize);
                ftromino(X_Position + subboardSize, Y_Position, Missing_X_Rbottom, Missing_Y_Rbottom, subboardSize);
                ftromino(X_Position, Y_Position, Missing_X_Lbottom, Missing_Y_Lbottom, subboardSize);
    }


    public static void main(String[] args) 
	{
		tromino tromino= new tromino();
		int boardSize, X_missPos, Y_missPos;  /*coordinates of missing square */
		Scanner sc = new Scanner(System.in);
        int tromino_Count ;
		do 
		{
			System.out.println( "\n Enter the size of board: " );
			boardSize = (int) sc.nextInt();
            tromino_Count = ((boardSize * boardSize) - 1 ) / 3 ;
			if(boardSize>0) 
			{
				System.out.println( "\n Update the co-ordinates of the missing square: " );
				X_missPos = (int) sc.nextInt();
				Y_missPos = (int) sc.nextInt();
				System.out.println( "\n The Coordinates of  Trominos used and their orientation are:\n" );
				tromino.ftromino( 0, 0, X_missPos, Y_missPos, boardSize );
                System.out.println( "\n Total number of Trominos used:" +tromino_Count +"\n" );
			}
		} while (boardSize>0);
    }
}
