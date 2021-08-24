class Solution {
    
    private String multiply(int a,int b,int c,int d){
        int real=a*c-b*d;
        int com=a*d+b*c;
        if(real==0 && com==0){
            return "0+0i";
        }
        
        if(real==0){
            return "0"+"+"+Integer.toString(com)+"i";
        }
        if(com==0){
            return Integer.toString(real)+"+"+"0i";
        }
        return Integer.toString(real)+"+"+Integer.toString(com)+"i";
    }
    
    public String complexNumberMultiply(String num1, String num2) {
        int a,b,c,d;
        String[] A = num1.split("\\+");
        String[] B = num2.split("\\+");
        
        a=Integer.parseInt(A[0]);
        c=Integer.parseInt(B[0]);
        b=Integer.parseInt(A[1].substring(0,A[1].length()-1));
        d=Integer.parseInt(B[1].substring(0,B[1].length()-1));
        //System.out.println(a+" "+b+" "+c+" "+d);
        return multiply(a,b,c,d);
    }
}