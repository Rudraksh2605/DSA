
class Solution {

    public int[][] floodFill(
        int[][] image,
        int sr,
        int sc,
        int color
    ) {
        int originalColor = image[sr][sc];

        // Question-solving logic:
        // If the new color is already the same, nothing to do.
        if (originalColor == color) {
            return image;
        }

        // Traversal logic
        bfs(image, sr, sc, originalColor, color);

        return image;
    }


    // -----------------------------
    // TRAVERSAL LOGIC
    // -----------------------------

    private void bfs(
        int[][] grid,
        int startRow,
        int startCol,
        int originalColor,
        int newColor
    ) {

        Queue<int[]> queue = new ArrayDeque<>();

        // Start BFS
        queue.offer(new int[]{startRow, startCol});

        // Mark starting cell as visited
        grid[startRow][startCol] = newColor;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            // Explore neighbors
            for (int[] neighbor : getNeighbors(row, col)) {

                int newRow = neighbor[0];
                int newCol = neighbor[1];

                // Is this neighbor valid for traversal?
                if (isValid(
                    grid,
                    newRow,
                    newCol,
                    originalColor
                )) {

                    // Mark visited
                    grid[newRow][newCol] = newColor;

                    // Continue BFS
                    queue.offer(new int[]{
                        newRow,
                        newCol
                    });
                }
            }
        }
    }


    // -----------------------------
    // NEIGHBOR LOGIC
    // -----------------------------

    private int[][] getNeighbors(int row, int col) {

        return new int[][]{
            {row - 1, col}, // up
            {row + 1, col}, // down
            {row, col - 1}, // left
            {row, col + 1}  // right
        };
    }


    // -----------------------------
    // VALIDATION LOGIC
    // -----------------------------

    private boolean isValid(
        int[][] grid,
        int row,
        int col,
        int originalColor
    ) {

        // Outside grid
        if (row < 0 ||
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length) {

            return false;
        }

        // Not part of the region
        if (grid[row][col] != originalColor) {
            return false;
        }

        return true;
    }
}

