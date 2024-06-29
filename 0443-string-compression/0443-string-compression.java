class Solution {
    public int compress(char[] arr) {
        StringBuilder ans = new StringBuilder("");
        int i=0,j=0;
        while(j<arr.length){
            if(arr[j]==arr[i]) j++;
            else{
                ans.append(arr[i]);
                int len = j-i;
                if(len>1){
                    ans.append(len);
                }
                i=j;
            }
        }
        ans.append(arr[i]);
        int len = j-i;
        if(len>1){
            ans.append(len);
            }
        i=j;
        for(int a =0;a<ans.length();a++){
            arr[a] = ans.charAt(a);
        }
        return ans.length();
    }
}