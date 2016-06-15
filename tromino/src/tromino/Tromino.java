/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tromino;

/**
 *
 * @author adithya_2
 */

import java.util.Scanner;

public class Tromino
{
           int  co_X_Centre,                   
                co_Y_Centre,          
                co_X_Upleft_Missing,
                co_Y_Upleft_Missing,
                co_X_Upright_Missing,
                co_Y_Upright_Missing,
                co_X_Lowright_Missing,
                co_Y_Lowright_Missing, 
                co_X_Lowleft_Missing, 
                co_Y_Lowleft_Missing; 
		
// No argument constructor		
    public  Tromino()
    {
    }

     
    
    
	public void trimino (int co_X_Board, int co_Y_Board, int co_X_missing, int co_Y_missing, int boardSize) 
	{
        int subboardSize = boardSize / 2;    /* size of sub-board */
                
		
        if (boardSize == 2) 
		{   
            System.out.println((co_X_Board + 1)+" "+(co_Y_Board + 1));
            /* Finding  the orientation according to missing square */
            if (co_X_Board == co_X_missing)  
			{
                if (co_Y_Board == co_Y_missing)  
				{
                    System.out.println("Orientation 0\n");
                } 
				else  
				{
                    System.out.println("Orientation 1\n");
                }
            } 
else
                if (co_Y_Board == co_Y_missing)
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
        co_X_Centre = co_X_Board + subboardSize;
        co_Y_Centre = co_Y_Board + subboardSize;

       
        System.out.println(co_X_Centre+" "+co_Y_Centre);

/*  Computing the orientation according to missing square */
        if (co_X_missing < co_X_Centre) 
		{		 
            co_X_Upright_Missing = co_X_Lowright_Missing = co_X_Centre;
            co_Y_Upright_Missing = co_Y_Centre;
            co_Y_Lowright_Missing = co_Y_Centre - 1;
			/* Orientation 0 */
            if (co_Y_missing < co_Y_Centre) 
			{			
                System.out.println("Orientation 0\n");
                co_X_Upleft_Missing = co_X_Centre - 1;
                co_Y_Upleft_Missing = co_Y_Centre;
                co_X_Lowleft_Missing = co_X_missing;
                co_Y_Lowleft_Missing = co_Y_missing;
            }
			/* Orientation 1 */			
			else 
			{		 
                System.out.println("Orientation 1\n");
                co_X_Upleft_Missing = co_X_missing;
                co_Y_Upleft_Missing = co_Y_missing;
                co_X_Lowleft_Missing = co_X_Centre - 1;
                co_Y_Lowleft_Missing = co_Y_Centre - 1;
            }
        }
				
		else 
		{
            co_X_Upleft_Missing = co_X_Lowleft_Missing = co_X_Centre - 1;
            co_Y_Upleft_Missing = co_Y_Centre;
            co_Y_Lowleft_Missing = co_Y_Centre - 1;
			/* Orientation 3*/
            if (co_Y_missing < co_Y_Centre) 
			{			
                System.out.println("Orientation 3\n");
                co_X_Upright_Missing = co_X_Centre;
                co_Y_Upright_Missing = co_Y_Centre;
                co_X_Lowright_Missing = co_X_missing;
                co_Y_Lowright_Missing = co_Y_missing;
            } 
			/* Orientation 2*/
			else 
			{		
				System.out.println("Orientation 2\n");
                co_X_Upright_Missing = co_X_missing;
                co_Y_Upright_Missing = co_Y_missing;
                co_X_Lowright_Missing = co_X_Centre;
                co_Y_Lowright_Missing = co_Y_Centre - 1;
            }
        }

        /* Calling trimino recursively for all four sub-boards */
        trimino(co_X_Board, co_Y_Board + subboardSize, co_X_Upleft_Missing, co_Y_Upleft_Missing, subboardSize);
        trimino(co_X_Board + subboardSize, co_Y_Board + subboardSize, co_X_Upright_Missing, co_Y_Upright_Missing, subboardSize);
        trimino(co_X_Board + subboardSize, co_Y_Board, co_X_Lowright_Missing, co_Y_Lowright_Missing, subboardSize);
        trimino(co_X_Board, co_Y_Board, co_X_Lowleft_Missing, co_Y_Lowleft_Missing, subboardSize);
    }


    public static void main(String[] args) 
	{
		Tromino tromino= new Tromino();
		int boardSize, co_X_missing, co_Y_missing;  /*coordinates of missing square */
		Scanner sc = new Scanner(System.in);
                int tromino_Count ;
		do 
		{
			System.out.println( "\n------------------------------------------------------------------------" );
			System.out.println( "\n Enter the size of board: " );
			boardSize = (int) sc.nextInt();
                        tromino_Count = ((boardSize * boardSize) - 1 ) / 3 ;
			if(boardSize>0) 
			{
				System.out.println( "\n Please enter coordinates of missing square: " );
				co_X_missing = (int) sc.nextInt();
				co_Y_missing = (int) sc.nextInt();
				System.out.println( "\n\n The Coordinates of  Trominos used and their orientation are:\n" );
				tromino.trimino( 0, 0, co_X_missing, co_Y_missing, boardSize );
                                System.out.println( "\n\n Total number of trominos used:" +tromino_Count +"\n" );
			}
		} while (boardSize>0);
    }
}
