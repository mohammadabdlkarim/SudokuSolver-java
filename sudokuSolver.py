Board = [
    [0, 2, 0, 0, 4, 0, 0, 0, 8],
    [0, 6, 4, 0, 0, 9, 0, 3, 0],
    [0, 0, 0, 1, 0, 6, 4, 0, 0],
    [8, 0, 9, 0, 5, 4, 0, 0, 0],
    [3, 0, 0, 8, 0, 0, 0, 1, 4],
    [2, 0, 0, 0, 3, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 5, 9],
    [0, 7, 0, 0, 0, 5, 2, 0, 0],
    [0, 0, 2, 0, 0, 0, 0, 0, 7]
]

def find_empty(board):
    for i in range(0, 9):
        for j in range(0, 9):
            if board[i][j] == 0:
                return i, j


def not_in_row(board, num, row, col):
    for j in range(0,9):
        if board[row][j] == num and col != j:
            return False
    return num


def not_in_col(board, num, row, col):
    for i in range(0,9):
        if board[i][col] == num and row != i:
            return False
    return num


def not_in_box(board, num, row, col):
    first_in_box_row = row - (row % 3)
    first_in_box_col = col - (col % 3)
    for i in range(first_in_box_row, first_in_box_row + 3):
        for j in range(first_in_box_col, first_in_box_col + 3):
            if board[i][j] == num and (row, col) != (i, j):
                return False
    return num


def is_valid(board, num, row, col):
    if  not_in_row(board,num, row, col) and not_in_col(board, num, row, col) and not_in_box(board, num, row, col):
        return True
    return False


def solve(board):
    empty = find_empty(board)
    if not empty:
        return True
    row , col = empty

    for number in range(1,10):
        if is_valid(board, number, row, col):
            board[row][col] = number
            if solve(board):
                return True
            board[row][col] = 0
    return False

def print_board(board):
    for i in range(len(board)):
        if i % 3 == 0 and i != 0:
            print("- - - - - - - - - - -")
            
        for j in range(len(board)):
            if j % 3 == 0 and j != 0:
                print("|", end=" ")
            if j == 8:
                print(str(board[i][j]))
            else:
                print(str(board[i][j]), end = " ")

print_board(Board)
solve(Board)
print("Solving...")
print_board(Board)
