func updateMatrix(mat [][]int) [][]int {
    m := len(mat)
    n := len(mat[0])
    result := make([][]int, m)
    for i := range result {
        result[i] = make([]int, n)
        for j := range result[i] {
            result[i][j] = math.MaxInt32
        }
    }

    directions := [][]int{
        {-1, 0}, // Up
        {1, 0},  // Down
        {0, -1}, // Left
        {0, 1},  // Right
    }

    queue := [][]int{}
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if mat[i][j] == 0 {
                queue = append(queue, []int{i, j})
                result[i][j] = 0
            }
        }
    }

    for len(queue) > 0 {
        cell := queue[0]
        queue = queue[1:]
        r, c := cell[0], cell[1]

        for _, direction := range directions {
            newRow := r + direction[0]
            newCol := c + direction[1]

            if newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                result[newRow][newCol] > result[r][c]+1 {
                result[newRow][newCol] = result[r][c] + 1
                queue = append(queue, []int{newRow, newCol})
            }
        }
    }

    return result
}
