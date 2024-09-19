class Solution {
    public List<Integer> ways(int i,int j,String str){
        List<Integer> ans = new ArrayList<>();
        String base = str.substring(i,j+1);
        if(base.matches("\\d+")){
            ans.add(Integer.parseInt(base));
            return ans;
        }
        
        for(int k=i;k<j;k++){
            char ch = str.charAt(k);
            if(ch=='+' || ch=='-' || ch=='*'){
                List<Integer> left = ways(i,k-1,str);
                List<Integer> right = ways(k+1,j,str);
                for(int l :left){
                    for(int r : right){
                        if(ch=='+') ans.add(l+r);
                        else if(ch=='-') ans.add(l-r);
                        else ans.add(l*r);
                    }
                }
            }
        }
        return ans;
    } 
    public List<Integer> diffWaysToCompute(String str) {
        return ways(0,str.length()-1,str);
    }
}