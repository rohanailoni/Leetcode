func canCross(stones []int) bool {
    dp := make(map[node]bool)
    mapper := make(map[int]int)
    n := len(stones)
    
    // Mark stones in the map to identify if such stone exists or not.
    for i := 0; i < n; i++ {
        mapper[stones[i]] = i
    }
    
    return solve(stones, &dp, n, 0, 0, &mapper)
}

type node struct {
    index     int
    prevIndex int
}

func solve(stones []int, dp *map[node]bool, n int, index int, prevJump int, mapper *map[int]int) bool {
    if index == n-1 {
        return true
    }
    
    val, ok := (*dp)[node{index: index, prevIndex: prevJump}]
    if ok {
        return val
    }
    
    ans := false
    for nextJump := prevJump - 1; nextJump <= prevJump+1; nextJump++ {
        val, ok := (*mapper)[stones[index]+nextJump]
        if nextJump > 0 && ok {
            ans = ans || solve(stones, dp, n, val, nextJump, mapper)
        }
    }
    
    (*dp)[node{index: index, prevIndex: prevJump}] = ans
    return ans
}
