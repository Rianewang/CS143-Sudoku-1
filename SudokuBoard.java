import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuBoard { 
   private int [][] board;
   
   public SudokuBoard (String fileName) throws FileNotFoundException {
      board = new int [9][9];
      File f = new File(fileName);
      Scanner s = new Scanner (f);
      
      for (int r= 0; r<9; r++ ) {
         if (s.hasNextLine()) {
            String line = s.nextLine();
            for (int c=0; c< 9; c++){
               char num = line.charAt(c);
               
               if(num=='.') {
                  board[r][c]=0;
               } else {
                  board[r][c]= num-'0';
               }
            }
         }
         
      }
   }
   
   public String toString () {
      String result = "";
      for (int r=0;r<9;r++) {
         if (r%3 ==0) {
            result += "| - - - + - - - + - - - |\n";
         }
         for (int c=0; c<9; c++) {
            if(c%3==0) {
               result+="| ";
            }
            if (board[r][c]==0) {
               result += ". ";
            } else {
               result += board[r][c] + " ";
            }
         }
         result += "| \n";
         
      }
      result += "| - - - + - - - + - - - |\n";
      return result;
   }
}

/*
# PROGRAM OUTPUT
 | - - - + - - - + - - - |
 | 2 . . | 1 . 5 | . . 3 | 
 | . 5 4 | . . . | 7 1 . | 
 | . 1 . | 2 . 3 | . 8 . | 
 | - - - + - - - + - - - |
 | 6 . 2 | 8 . 7 | 3 . 4 | 
 | . . . | . . . | . . . | 
 | 1 . 5 | 3 . 9 | 8 . 6 | 
 | - - - + - - - + - - - |
 | . 2 . | 7 . 1 | . 6 . | 
 | . 8 1 | . . . | 2 4 . | 
 | 7 . . | 4 . 2 | . . 1 | 
 | - - - + - - - + - - - |
*/