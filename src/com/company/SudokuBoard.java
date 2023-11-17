package com.company;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(){
        board = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=0;
            }
        }
    }

    public int getCell(int row, int col){
        return board[row][col];
    }

    public void setCell(int row,int col,int value){
        board[row][col] = value;
    }

    public void fillBoard(int[][] initialValues){
        if(initialValues.length != 9 || initialValues[0].length !=9){
            System.out.println("Invalid input for initial values. The array must be 9x9.");
            return;
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = initialValues[i][j];
            }
        }

    }

    public void displayBoard(){
        System.out.println("----------------------");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(j%3==0) System.out.print("|");
                System.out.print(board[i][j] + " ");
            }

            System.out.println("|");

            if (i == 8) {
                System.out.println("----------------------");
            } else if ((i + 1) % 3 == 0) {
                System.out.println("|--------------------|");
            }
        }
    }

}
