package com.ning.array;

public class java036有效的数独 {
    public static void main(String[] args) {
        Solution036 solution036 = new Solution036();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'8', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean flag = solution036.isValidSudoku(board);
        System.out.println(flag);
    }
}


class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        int[][] cows = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = 0;
                if (board[i][j] != '.') {
                    num = (board[i][j] - '0')-1;
                    cows[i][num]++;
                    column[j][num]++;
                    boxes[i / 3][j / 3][num]++;
                }
                if (cows[i][num] > 1 || column[j][num] > 1 || boxes[i / 3][j / 3][num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}