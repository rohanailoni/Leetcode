type minheap struct{
	heap []int
}

func NewMinHeap() *minheap {
	return &minheap{
		heap: make([]int, 0),
	}
}


func (h *minheap) Insert(n int){
	h.heap=append(h.heap,n);
	h.heapifyUp(len(h.heap)-1);
}


func (h *minheap) heapifyUp(index int){
	parentIdx:= (index-1)/2;
	for index>0 && h.heap[parentIdx]>h.heap[index]{
		h.heap[parentIdx],h.heap[index]=h.heap[index],h.heap[parentIdx];
		index=parentIdx;
		parentIdx= (index-1)/2;
	}

}
func (h *minheap) heapifyDown(index int){
	
	for{
		left:=2*index+1;
		right:= 2*index+2;
		small:=index;
		
		if  left<len(h.heap)  && h.heap[left] < h.heap[small]{
			small=left;
		}

		if right<len(h.heap)  && h.heap[right] < h.heap[small]{
			small=right;
		}
		if small==index{
			break
		}
		h.heap[small],h.heap[index]=h.heap[index],h.heap[small];
		index=small;
	}
}
func (h *minheap) ExtractMin()(int,bool){
    if len(h.heap)==0 {
        return -1,false;
    } 
	min:=h.heap[0];
	index:= len(h.heap)-1;
	h.heap[0]=h.heap[index];
	h.heap=h.heap[:index];
	h.heapifyDown(0);
	return min,true;
}

type NumberContainers struct {
    indexMap map[int]int
    containerMap map[int] *minheap
}


func Constructor() NumberContainers {
    return NumberContainers{
			indexMap:make(map[int]int),  // index:number
			containerMap:make(map[int]*minheap), //number : priorityqueue(index)
		}
}


func (this *NumberContainers) Change(index int, number int)  {
    this.indexMap[index]=number;
		if _,ok:=this.containerMap[number];!ok{
			this.containerMap[number]= NewMinHeap();
		}
		this.containerMap[number].Insert(index);
}


func (this *NumberContainers) Find(number int) int {
    if heap,ok:=this.containerMap[number];ok{
			for {
				index,error:=heap.ExtractMin()
				
				//fmt.Println(this.indexMap,index,heap,error,number);
				
				if error ==true{
					if has,ok:=this.indexMap[index];ok{
						
						if has==number{
							heap.Insert(index)
							return index;
						}else{

						}
					}else{

					}
				}else{
					return -1;
				}
			}
			
		}else{
			return -1;
		}
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Change(index,number);
 * param_2 := obj.Find(number);
 */