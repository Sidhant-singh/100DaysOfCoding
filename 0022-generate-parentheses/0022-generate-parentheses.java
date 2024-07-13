class Solution {
    public void print(int open,int close,int n,String s,List<String> arr){
        if(s.length()==2*n){
            arr.add(s);
            return;
        }
        
        
        if(open<n) print(open+1,close,n, s+'(',arr);
        if(close<open) print(open,close+1,n, s+')',arr);
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        print(0,0,n,"",arr);
        return arr;
    }
}