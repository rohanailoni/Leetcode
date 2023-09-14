

func findItinerary(tickets [][]string) []string {
    // Create a graph to represent the tickets
    graph := make(map[string][]string)
    for _, ticket := range tickets {
        from, to := ticket[0], ticket[1]
        graph[from] = append(graph[from], to)
    }

    // Sort the destinations in lexicographical order
    for _, destinations := range graph {
        sort.Strings(destinations)
    }

    // Perform DFS to find the itinerary
    var result []string
    var dfs func(node string)
    dfs = func(node string) {
        for len(graph[node]) > 0 {
            next := graph[node][0]
            graph[node] = graph[node][1:]
            dfs(next)
        }
        result = append(result, node)
    }

    dfs("JFK")
    reverse(result) // Reverse the result to get the correct order

    return result
}

func reverse(arr []string) {
    for i, j := 0, len(arr)-1; i < j; i, j = i+1, j-1 {
        arr[i], arr[j] = arr[j], arr[i]
    }
}
