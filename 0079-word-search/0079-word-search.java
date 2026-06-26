class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Try every cell as the starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }

            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {

        // Base Case 1: Entire word matched
        if (index == word.length()) {
            return true;
        }

        // Base Case 2: Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Base Case 3: Character mismatch
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Save current character
        char temp = board[row][col];

        // Mark as visited
        board[row][col] = '#';

        // Explore all four directions
        boolean found =
                dfs(board, word, row - 1, col, index + 1) ||   // Up
                dfs(board, word, row + 1, col, index + 1) ||   // Down
                dfs(board, word, row, col - 1, index + 1) ||   // Left
                dfs(board, word, row, col + 1, index + 1);     // Right

        // Backtrack
        board[row][col] = temp;

        return found;
    }
}