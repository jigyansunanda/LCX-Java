class Solution {
    private int m, n;
    private boolean[][] marked;
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private boolean isValid(int r, int c) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.marked = new boolean[7][7];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length() - 1) return true;
        marked[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int r = x + dx[i], c = y + dy[i];
            if (isValid(r, c) && word.charAt(index + 1) == board[r][c]) {
                if (!marked[r][c]) {
                    if (dfs(board, word, r, c, index + 1)) return true;
                }
            }
        }
        marked[x][y] = false;
        return false;
    }
}