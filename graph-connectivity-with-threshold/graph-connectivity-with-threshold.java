class Solution {
    class unionfind{
        int[] record;
        unionfind(int n){
            record=new int[n+1];
            for(int i=0;i<=n;i++){
                
                record[i]=i;
            }
            
        }
        
        int findinrecord(int vertex){
            if(record[vertex]==vertex){
                return vertex;
            }
            int x=findinrecord(record[vertex]);
            record[vertex]=x;
            
            return x;
        }
        
        void union(int v1,int v2){
            int p1=findinrecord(v1);
            int p2=findinrecord(v2);
            if(p1!=p2){
                record[p1]=p2;
            }
            return;
        }
        
        Boolean check(int i,int j){
            
            return findinrecord(i)==findinrecord(j);
        }
        
    }
    
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        
        List<Boolean>ans=new ArrayList<>();
        unionfind un=new unionfind(n);
        if(threshold==0){
            for(int i=0;i<queries.length;i++){
                ans.add(true);
            }
            return ans;
        }
        for(int i=1;i<n+1;i++){
            for(int j=2*i;j<n+1;j+=i){
                if(i>threshold){
                    un.union(i,j);
                }
            }
        }
        for(int i=0;i<queries.length;i++){
            ans.add(un.check(queries[i][0],queries[i][1]));
        }
        
        return ans;
        
        
    }
            

        
        
} 