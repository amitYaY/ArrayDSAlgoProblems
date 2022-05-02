package com.ds.algo;

public class SolutionServices22 {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        SolutionServices22 services = new SolutionServices22();
        System.out.println(services.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] b = new boolean[m][n];

        int k = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(k)) {
                    b = new boolean[m][n];
                    b[i][j] = true;
                    if(validate(board, word, i, j, m, n, k+1, b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean validate(char[][] board, String s, int sR, int sC, int m, int n, int k, boolean[][] b) {

        if(k == s.length()) {
            return true;
        }

        if(sR - 1 >= 0 && board[sR-1][sC] == s.charAt(k) && !b[sR-1][sC]) {
            boolean[][] b1 = b.clone();
            b1[sR-1][sC] = true;
            if(validate(board, s, sR-1, sC, m, n, k+1, b1)) {
                return true;
            }
            b1[sR-1][sC] = false;
        }
        if(sR + 1 < m && board[sR+1][sC] == s.charAt(k) && !b[sR+1][sC]) {
            boolean[][] b1 = b.clone();
            b1[sR+1][sC] = true;
            if(validate(board, s, sR+1, sC, m, n, k+1, b1)) {
                return true;
            }
            b1[sR+1][sC] = false;
        }
        if(sC - 1 >= 0 && board[sR][sC-1] == s.charAt(k) && !b[sR][sC-1]) {
            boolean[][] b1 = b.clone();
            b1[sR][sC-1] = true;
            if(validate(board, s, sR, sC-1, m, n, k+1, b1)) {
                return true;
            }
            b1[sR][sC-1] = false;
        }
        if(sC + 1 < n && board[sR][sC+1] == s.charAt(k) && !b[sR][sC+1]) {
            boolean[][] b1 = b.clone();
            b1[sR][sC+1] = true;
            if(validate(board, s, sR, sC+1, m, n, k+1, b1)) {
                return true;
            }
            b1[sR][sC+1] = false;
        }
        return false;
    }

}
