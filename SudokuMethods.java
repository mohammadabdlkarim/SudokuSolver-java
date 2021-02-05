public class SudokuMethods {
    private static final int SIZE = 9;
    private static final int [] FINISHED = {9,9};
    //find the empty cell
    public int [] findEmpty( int [][] board){
        for(int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        return FINISHED;
    }
    //check if the row contains the same value
    public boolean isInRow(int[][]board, int num, int row, int col){
        for(int i = 0; i<SIZE; i++){
            if(board[row][i]==num && i != col)
                return true;
        }
        return false;
    }
    //check if the column contains the same value
    public boolean isInCol(int [][] board, int num, int row, int col){
        for(int i  = 0; i < SIZE; i++){
            if(board[i][col] == num && i!= row)
                return true;
        }
        return false;
    }
    //check if the box contains the same value
    public boolean isInBox(int[][]board, int num, int row, int col){
        int firstColInBox = col - (col % 3);
        int firstRowInBox = row - (row % 3);
        for(int i = firstRowInBox; i<firstRowInBox + 3; i++){
            for(int j = firstColInBox; j< firstColInBox + 3; j++){
                if(board[i][j]==num)
                    return true;
            }
        }
        return false;
    }
    //check if the value is valid in the cell
    public boolean isValid(int[][]board, int num, int row, int col){
        return !isInRow(board, num, row, col) && !isInCol(board, num, row, col) && !isInBox(board, num, row, col);
    }
    //solve the board using backtracking
    public boolean solve(int[][] board){
        int [] empty = findEmpty(board);
        int row, col;
        if(empty == FINISHED)
            return true;
        row = empty[0];
        col = empty[1];
        //try numbers
        for(int number = 1; number<=SIZE; number++){
            if(isValid(board, number, row, col)) {
                board[row][col] = number;
                if(solve(board))
                    return true;
                board[row][col]=0;
            }
        }
        return false;
    }
    //to print our results
    public void printBoard(int[][]board){
        for(int i= 0; i< SIZE;i++){
            if(i % 3 == 0 && i != 0)
                System.out.println("- - - - - - - - - - - ");
            for(int j = 0; j<SIZE; j++) {
                if(j % 3 == 0 && j != 0)
                    System.out.print("|");
                if(j == SIZE-1)
                    System.out.println(board[i][j]);
                else
                    System.out.print(board[i][j] + " ");
            }
        }
    }
}
