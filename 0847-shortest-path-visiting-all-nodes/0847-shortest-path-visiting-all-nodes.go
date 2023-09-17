type State struct {
	mask, node, dist int
}

func shortestPathLength(graph [][]int) int {
    n:=len(graph)
    queue:=[]State{}
    visited := make(map[int]bool)
    for i:=0;i<n;i++{
        queue=append(queue,State{1<<i,i,0})
        visited[(1<<i)*16+i] = true
        
    }
    mini:=(1<<n)-1
    for len(queue)>0{
        curr:=queue[0]
        queue=queue[1:]
        
        if curr.mask==(1<<n)-1{
            mini=min(mini,curr.dist);
        }
        for _, neighbor := range graph[curr.node] {
			newMask := curr.mask | (1 << neighbor)
			hashValue := newMask*16 + neighbor

			if !visited[hashValue] {
				visited[hashValue] = true
				queue = append(queue, State{newMask, neighbor, curr.dist + 1})
			}
			
		}
    }
    
    return mini
}
func min(a,b int)int{
    if a>b{
        return b
    }
    return a
}