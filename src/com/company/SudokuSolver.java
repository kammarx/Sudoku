package com.company;

public class SudokuSolver {

   public static boolean solveSudoku(SudokuBoard board){
      int[] emptyCell = findEmptyCell(board);
      if(emptyCell == null){
         return true;
      }

      int row = emptyCell[0];
      int col = emptyCell[1];

      for (int num = 1; num <= 9; num++) {
         if (isValidMove(board, row, col, num)) {
            board.setCell(row, col, num);

            if (solveSudoku(board)) {
               return true;
            }

            board.setCell(row, col, 0);
         }
      }
      return false;

   }

   private static int[] findEmptyCell(SudokuBoard board) {
      for (int i = 0; i < 9; i++) {
         for (int j = 0; j < 9; j++) {
            if(board.getCell(i, j) == 0){
               return new int[]{i,j};
            }
         }
      }
      return null;
   }

   private static boolean isValidMove(SudokuBoard board, int row, int col, int num) {
      return !usedInRow(board, row, num) &&
              !usedInColumn(board, col, num) &&
              !usedInSubgrid(board, row - row % 3, col - col % 3, num);
   }

   private static boolean usedInRow(SudokuBoard board, int row, int num) {
      for (int i = 0; i < 9; i++) {
         if (board.getCell(row, i) == num) {
            return true;
         }
      }
      return false;
   }

   private static boolean usedInColumn(SudokuBoard board, int col, int num) {
      for (int i = 0; i < 9; i++) {
         if (board.getCell(i, col) == num) {
            return true;
         }
      }
      return false;
   }

   private static boolean usedInSubgrid(SudokuBoard board, int startRow, int startCol, int num) {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if (board.getCell(i + startRow, j + startCol) == num) {
               return true;
            }
         }
      }
      return false;
   }
}

