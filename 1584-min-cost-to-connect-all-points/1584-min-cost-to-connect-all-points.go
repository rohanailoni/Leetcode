type UnionFind struct {
    parent []int
    rank   []int
}

func newUnionFind(n int) *UnionFind {
    uf := &UnionFind{
        parent: make([]int, n),
        rank:   make([]int, n),
    }
    for i := 0; i < n; i++ {
        uf.parent[i] = i
        uf.rank[i] = 0
    }
    return uf
}

func (uf *UnionFind) find(x int) int {
    if uf.parent[x] != x {
        uf.parent[x] = uf.find(uf.parent[x])
    }
    return uf.parent[x]
}

func (uf *UnionFind) union(x, y int) {
    rootX := uf.find(x)
    rootY := uf.find(y)

    if rootX != rootY {
        if uf.rank[rootX] < uf.rank[rootY] {
            rootX, rootY = rootY, rootX
        }
        uf.parent[rootY] = rootX
        if uf.rank[rootX] == uf.rank[rootY] {
            uf.rank[rootX]++
        }
    }
}

func minCostConnectPoints(points [][]int) int {
    manhattanDistance := func(p1, p2 []int) int {
        return abs(p1[0]-p2[0]) + abs(p1[1]-p2[1])
    }

    n := len(points)
    edges := make([][3]int, 0) // [distance, point1, point2]
    for i := 0; i < n; i++ {
        for j := i + 1; j < n; j++ {
            dist := manhattanDistance(points[i], points[j])
            edges = append(edges, [3]int{dist, i, j})
        }
    }

    sort.Slice(edges, func(i, j int) bool {
        return edges[i][0] < edges[j][0]
    })

    uf := newUnionFind(n)
    minCost := 0
    numEdges := 0

    for _, edge := range edges {
        dist, i, j := edge[0], edge[1], edge[2]
        if uf.find(i) != uf.find(j) {
            uf.union(i, j)
            minCost += dist
            numEdges++
            if numEdges == n-1 {
                break
            }
        }
    }

    return minCost
}

func abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}
