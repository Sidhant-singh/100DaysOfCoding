class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    l.add(1);
                }
                else{
                    l.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
            res.add(l);
        }
        return res;
    }
}