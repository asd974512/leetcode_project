package com.ning.hot100;

public class java079单词搜索 {
    public static void main(String[] args) {
        Solution079 solution079 = new Solution079();
        char[][] board = {{'a', 'b', 'a'}};
        String str = "aba";
        boolean exist = solution079.exist(board, str);
        System.out.println(exist);
    }
}

class Solution079 {

    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int length = word.length();
        if (length == 0) {
            return false;
        }
        int firstChar = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == firstChar) {
                    boolean[][] used = new boolean[board.length][board[0].length];
                    dfs(board, i, j, 0, word, used);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void dfs(char[][] board, int row, int col, int index, String word, boolean[][] used) {
        int N = board.length;
        int M = board[0].length;
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return;
        }
        if (board[row][col] == word.charAt(index) && !used[row][col]) {
            index++;
        } else {
            return;
        }
        if (index == word.length()) {
            flag = true;
            return;
        }
        used[row][col] = true;
        dfs(board, row, col + 1, index, word, used);
        dfs(board, row, col - 1, index, word, used);
        dfs(board, row + 1, col, index, word, used);
        dfs(board, row - 1, col, index, word, used);
        used[row][col] = false;
    }
}
