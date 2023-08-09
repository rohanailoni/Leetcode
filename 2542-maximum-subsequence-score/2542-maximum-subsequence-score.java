// class Solution {
//     public long maxScore(int[] nums1, int[] nums2, int k) {
//         ArrayList<Node>sto=new ArrayList<>();
//         int n=nums1.length;
//         PriorityQueue<Node>qu=new PriorityQueue<>((a,b)-> a.N1-b.N1);
//         for(int i=0;i<n;i++){
//             Node temp=new Node(nums1[i],nums2[i]);
//             sto.add(temp);
            
//         }
//         Collections.sort(sto,(a,b)->b.N2-a.N2);
//         int max=0;
//         int poi=0;
//         int currsum=0;
//         for(int i=0;i<k;i++){
//             currsum+=sto.get(i).N1;
//             qu.add(new Node(sto.get(i).N1,sto.get(i).N2));
//         }
//         for(int i=k;i<n;i++){
//             if(qu.peek().N2<sto.get(i).N2){
//                 currsum-=qu.remove().N1;

//                 int min=sto.get(i).N2;

//                 if(qu.size()>0){
//                     min=Integer.min(qu.peek().N2,min);
//                 }
//                 qu.add(new Node(sto.get(i).N1,sto.get(i).N2));
//                 currsum+=sto.get(i).N1;
//                 max=Integer.max(max,min*currsum);
//             }
//             // currsum+=sto.get(i).N1;
//             // qu.add(new Node(sto.get(i).N1,sto.get(i).N2));
//             // if(qu.size()>k){
                
                
//             //     currsum-=qu.poll().N1;
//             // }
//             // if (qu.size()==k){
//             //     max=Math.max(max,currsum*sto.get(i).N2);
                  
//             // }
//         }
//         return max;

//     }
// }


// class Node{
//     int N1;
//     int N2;
//     Node(int x,int y){
//         this.N1=x;
//         this.N2=y;
//     }
// }
class Solution {
    // Nested Pair class
    class Pair {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arrp = new Pair[n];
        
        // Create pairs from nums1 and nums2
        for (int i = 0; i < n; i++)
            arrp[i] = new Pair(nums1[i], nums2[i]);
        
        // Sort pairs in descending order of 'a'
        Arrays.sort(arrp, (p1, p2) -> -Integer.compare(p1.a, p2.a));
        
        // Create a priority queue to store pairs based on 'b'
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.b, p2.b));
        
        long sum = 0;
        
        // Select 'k' pairs with maximum 'a' values and add them to the priority queue
        for (int i = 0; i < k; i++) {
            sum += arrp[i].a;
            pq.add(arrp[i]);
        }
        
        // Calculate the initial maximum score
        long max = pq.peek().b * sum;
        
        // Process remaining pairs
        for (int i = k; i < n; i++) {
            if (pq.peek().b < arrp[i].b) {
                // Remove the pair with the minimum 'b' value
                sum -= (long) pq.remove().a;
                
                int min = arrp[i].b;
                
                // Get the minimum 'b' value among the remaining pairs
                if (pq.size() > 0)
                    min = Integer.min(pq.peek().b, min);
                
                // Add the current pair to the priority queue
                pq.add(arrp[i]);
                
                // Update the sum and calculate the maximum score
                sum += arrp[i].a;
                max = Long.max(max, min * sum);
            }
        }
        
        return max;
    }
}