class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        
        for(int i=0;i<points.length;i++){
            if(map.containsKey(points[i][0])){
                //map.put(points[i][0],map.get(points[i][0]).add(points[i][1]));
                map.get(points[i][0]).add(points[i][1]);
            }else{
                HashSet<Integer>s=new HashSet<>();
                s.add(points[i][1]);
                map.put(points[i][0],s);
                //map.put(points[i][0],map.get(points[i][0]).add());
                
            }
        }
        int min=(int)1e9;
        
        for(int i=0;i<points.length;i++){
            
            for(int j=i+1;j<points.length;j++){
                
                int a1=points[i][0];
                int a2=points[i][1];
                int b1=points[j][0];
                int b2=points[j][1];
                
                if(a1!=b1 && a2!=b2){
                    
                        if(map.get(a1).contains(b2) && map.get(b1).contains(a2)){
                            
                            int area=Math.abs(a2-b2)*Math.abs(a1-b1);
                            
                            min=Math.min(min,area);
                            
                            
                        }
                    
                }
                
                
                
            }
        }
        
        return min==(int)1e9?0:min;
        
        
        
        
    }
}