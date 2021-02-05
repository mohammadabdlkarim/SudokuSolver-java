public class Test {
    public static void main(String[]args){
        int [][] board = {
            {0, 0, 0, 0, 0, 0, 3, 0, 0},
            {0, 1, 0, 0, 9, 3, 4, 0, 6},
            {0, 0, 9, 0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 3, 9, 8, 0, 0},
            {2, 0, 0, 0, 4, 0, 0, 0, 0},
            {0, 7, 0, 2, 5, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 3, 5},
                {7, 2, 3, 0, 0, 0, 0, 6, 0}
        };
        SudokuMethods sudokuMethods = new SudokuMethods();
        sudokuMethods.printBoard(board);
        System.out.println("Solving");
        sudokuMethods.solve(board);
        sudokuMethods.printBoard(board);
    }
}
