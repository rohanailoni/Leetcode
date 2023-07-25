/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

type Queue struct{
    arr [] *Node;
}
func makeNewQueue()(*Queue){
    return &Queue{
        arr:make([]*Node,0),
    }
}
func (this *Queue) pop() *Node{
    //this should remove front element;
    //fmt.Println("arr:-",this.arr)
    node:=this.arr[0];
    this.arr=this.arr[1:];
    return node;
}
func (this *Queue) popLevel(level int) []*Node{
    nodes:=make([]*Node,0);
    for i:=0;i<level;i++{
        nodes=append(nodes,this.pop());
    }
    return nodes;
}
func (this *Queue) push(node *Node){
    this.arr=append(this.arr,node);
}

func (this *Queue) isEmpty()bool{
    if len(this.arr)==0{
        return true;
    }
    return false;
}
func connect(root *Node) *Node {
    if root==nil{
        return nil
    }
    level:=2;
	que:=makeNewQueue();
    if root.Left!=nil && root.Right!=nil{
        que.push(root.Left);
        que.push(root.Right);
    }
    for !que.isEmpty(){
        tmp:=que.popLevel(level);
        //fmt.Println(tmp,level)
        for i:=0;i<level-1;i++{
            tmp[i].Next=tmp[i+1];
            if tmp[i].Left!=nil && tmp[i].Right!=nil{
                que.push(tmp[i].Left);
                que.push(tmp[i].Right);
            }
        }
        if tmp[level-1].Left!=nil && tmp[level-1].Right!=nil{
            que.push(tmp[level-1].Left);
            que.push(tmp[level-1].Right);
        }
        
        level=level*2;
    }  
    return root;
}
